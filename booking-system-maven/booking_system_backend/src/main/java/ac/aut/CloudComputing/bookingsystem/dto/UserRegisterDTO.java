package ac.aut.CloudComputing.bookingsystem.dto;

import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class UserRegisterDTO {

    @Schema(description = "Username of the user", example = "john_doe", required = true)
    private String userName;

    @Schema(description = "Password of the user", example = "password123", required = true)
    private String password;

    @Schema(description = "Email address of the user", example = "john@example.com", required = true)
    private String email;

	/*
	 * @Schema(description = "Profile image file", required = true) private
	 * MultipartFile profileImage; // Use appropriate type for file upload
	 */
}
