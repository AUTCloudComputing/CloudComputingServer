package ac.aut.CloudComputing.bookingsystem.model;
 
import org.springframework.data.annotation.Id;   
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 


@Data  
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "User")
public class User{

	@Id
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String id;

	//user_name-index
	@DynamoDBAttribute(attributeName="user_name")
	private String userName;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String password;
	@DynamoDBAttribute
	private String role;
	@DynamoDBAttribute(attributeName="profile_image_S3Key")
	private String profileImageS3Key; // Reference to the user's profile image stored in S3
	

    @DynamoDBAttribute  
    private int status;
	 

}

 