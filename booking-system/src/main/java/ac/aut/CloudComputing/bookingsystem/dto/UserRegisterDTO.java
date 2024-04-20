package ac.aut.CloudComputing.bookingsystem.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class UserRegisterDTO {
    private String userName;
    private String password;
    private String email;
    private MultipartFile profileImage; // Use appropriate type for file upload
 
}


