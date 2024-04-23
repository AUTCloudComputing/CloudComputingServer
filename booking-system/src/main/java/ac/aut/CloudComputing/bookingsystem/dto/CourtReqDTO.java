package ac.aut.CloudComputing.bookingsystem.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class CourtReqDTO {

//    @Schema(description = "The unique identifier of the court", example = "uuid", required = false)
//    private String id;

    @Schema(description = "The name of the court", example = "1-12-1", required = true)
    private String courtName;

    @Schema(description = "The image file the court", required = false)
    private MultipartFile imageFile;

    @Schema(description = "The status of the court", example = "0", required = true)
    private int status;

    @Schema(description = "The description of the court", example = "1 No. 12 Level, 1 building", required = false)
    private String description; 


}
