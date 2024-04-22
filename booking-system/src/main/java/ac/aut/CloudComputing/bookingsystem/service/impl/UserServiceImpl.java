package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.mapper.UserMapper;
import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.repository.UserRepository;
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
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private S3Service s3Service;
 
    @Override
    public UserDetailsDTO loginUser(UserLoginDTO dto) {
    	 authenticationManager.authenticate(
    	            new UsernamePasswordAuthenticationToken(
    	                dto.getUserName(),
    	                dto.getPassword()
    	            )
    	        );
    	 
    	 
        User user = userRepository.findByUserName(dto.getUserName()).orElse(null);

        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Override
    public UserDetailsDTO registerUser(UserRegisterDTO dto) throws IOException {

    	// Map UserRegisterDTO to User entity
        User user = UserMapper.INSTANCE.userRegisterDTOToUser(dto); 

        // Upload profile image to S3
		/*
		 * String imageUrl = s3Service.uploadFile(dto.getProfileImage());
		 * user.setProfileImageS3Key(imageUrl);
		 */
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        
        return UserMapper.INSTANCE.userToUserDTO(user);
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
