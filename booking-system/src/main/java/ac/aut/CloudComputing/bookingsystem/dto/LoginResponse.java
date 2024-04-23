package ac.aut.CloudComputing.bookingsystem.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Login Response")
public class LoginResponse {

    @Schema(description = "Access token")
    private String token;

    @Schema(description = "Token expiration time in milliseconds")
    private long expiresIn;
}