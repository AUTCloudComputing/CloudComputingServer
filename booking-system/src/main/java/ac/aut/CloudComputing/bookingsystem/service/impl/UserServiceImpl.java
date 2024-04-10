package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ac.aut.CloudComputing.bookingsystem.dto.UserLoginRequest;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterRequest;
import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.repository.UserRepository;
import ac.aut.CloudComputing.bookingsystem.service.S3Service;
import ac.aut.CloudComputing.bookingsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    @Autowired
    S3Service s3Service;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
  

    @Override
    public User loginUser(UserLoginRequest request) {
        // Implement user login logic
		return null;
    }


	@Override
	public User registerUser(UserRegisterRequest request) throws IOException { 
		
		// Validate user data

        // Upload profile image to S3
        String imageUrl = uploadProfileImage(request.getProfileImage());

        // Store user data in DynamoDB
        storeUserDataInDynamoDB(request, imageUrl);
        
		return null;
	}
	
	 private String uploadProfileImage(MultipartFile profileImage) throws IOException {

		 return s3Service.uploadFile(profileImage);
	  }

    private void storeUserDataInDynamoDB(UserRegisterRequest registrationRequest, String imageUrl) {
    	
    	
        // Implement DynamoDB data storage logic here
    }
 

 
    
}
