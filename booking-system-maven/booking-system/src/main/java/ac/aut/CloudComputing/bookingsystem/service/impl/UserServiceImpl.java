package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.util.StringUtils;

import ac.aut.CloudComputing.bookingsystem.dto.LoginResponse;
import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.mapper.OrderMapper;
import ac.aut.CloudComputing.bookingsystem.mapper.UserMapper;
import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.repository.UserRepository;
import ac.aut.CloudComputing.bookingsystem.service.JwtService;
import ac.aut.CloudComputing.bookingsystem.service.S3Service;
import ac.aut.CloudComputing.bookingsystem.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder; 

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
 	private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
 
    private final S3Service s3Service;
    

    @Override
    public UserDetailsDTO getUserById(String id) {
        return userRepository.findById(id)
                .map(UserMapper.INSTANCE::userToUserDTO)
                .orElse(null);
    }


    @Override
    public void clearUsers() {
    	userRepository.deleteAll();
    }
 
    @Override
    public LoginResponse loginUser(UserLoginDTO dto) {
		 
		
		 authenticationManager.authenticate(
		            new UsernamePasswordAuthenticationToken(
		                dto.getUserName(),
		                dto.getPassword()
		            )
		        );
		 
   
	    User user = userRepository.findByUserName(dto.getUserName()).orElse(null);
	
	    UserDetailsDTO dto2 = UserMapper.INSTANCE.userToUserDTO(user);
	     
	
	    String jwtToken = jwtService.generateToken(dto2); 
	    LoginResponse loginResponse = new LoginResponse();
	    loginResponse.setToken(jwtToken);
	    loginResponse.setExpiresIn(jwtService.getExpirationTime());
	    
	    return loginResponse;
    }

    @Override
    public LoginResponse registerUser(UserRegisterDTO dto) throws IOException {

    	// Map UserRegisterDTO to User entity
        User user = UserMapper.INSTANCE.userRegisterDTOToUser(dto); 

        // Upload profile image to S3
		/*
		 * String imageUrl = s3Service.uploadFile(dto.getProfileImage());
		 * user.setProfileImageS3Key(imageUrl);
		 */
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        
        //trick
        if(!StringUtils.isNullOrEmpty(dto.getEmail()) 
        		&&  dto.getEmail().endsWith("@aut.ac.nz"))
        	user.setRole("ADMIN");
        
        userRepository.save(user);
        
        UserDetailsDTO dto2 = UserMapper.INSTANCE.userToUserDTO(user); 

        String jwtToken = jwtService.generateToken(dto2); 
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        
        return loginResponse;
    }

    


    public List<UserDetailsDTO> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);
  
        List<UserDetailsDTO> userDetailsDTOs = new ArrayList<>();
         

        for (User user : users) {
            UserDetailsDTO userDetailsDTO = UserMapper.INSTANCE.userToUserDTO(user);
            userDetailsDTOs.add(userDetailsDTO);
        }

        return userDetailsDTOs;
    }

	@Override
	public Optional<UserDetailsDTO> findByUserName(String userName) { 
   	   
		return userRepository.findByUserName(userName)
		        .map(user -> UserMapper.INSTANCE.userToUserDTO(user));

	}

}
