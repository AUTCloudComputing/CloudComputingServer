package ac.aut.CloudComputing.bookingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class UserLoginDTO {

    @Schema(description = "Username of the user", example = "john_doe", required = true)
    private String userName;

    @Schema(description = "Password of the user", example = "password123", required = true)
    private String password;

}
