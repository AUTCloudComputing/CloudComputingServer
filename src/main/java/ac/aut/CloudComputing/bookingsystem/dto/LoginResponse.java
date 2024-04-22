package ac.aut.CloudComputing.bookingsystem.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data 
public class LoginResponse {
	
    private String token;
    private long expiresIn;
 
}