package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.model.Order;
import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.repository.UserRepository;
import ac.aut.CloudComputing.bookingsystem.service.S3Service;
import ac.aut.CloudComputing.bookingsystem.service.UserService;



import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;


@Service
public class UserServiceImpl implements UserService {
 
    

    private final DynamoDBMapper dynamoDBMapper;
    
    
    @Autowired
    S3Service s3Service;

    @Autowired
    public UserServiceImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
  

    @Override
    public boolean loginUser(UserLoginDTO dto) {


    	Order order = dynamoDBMapper.load(Order.class, dto.getUserName()); 
		return true;
    }


	@Override
	public UserRegisterDTO registerUser(UserRegisterDTO dto) throws IOException { 
		
		// Validate user data
		 
        // Upload profile image to S3
        String imageUrl =  s3Service.uploadFile(dto.getProfileImage());

        // Store user data in DynamoDB
        

  	  	User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setProfileImageS3Key(imageUrl);
        dynamoDBMapper.save(user);
        return convertToDTO(user);
         
         
	} 

    private UserRegisterDTO convertToDTO(User user) {
    	UserRegisterDTO dto = new UserRegisterDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
 

 
    
}
