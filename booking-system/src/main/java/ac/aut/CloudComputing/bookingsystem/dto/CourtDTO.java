package ac.aut.CloudComputing.bookingsystem.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CourtDTO {

    @Schema(description = "The unique identifier of the court")
    private int id;

    @Schema(description = "The name of the court")
    private String courtName;

    @Schema(description = "The image URL of the court")
    private String image;

    @Schema(description = "The status of the court")
    private int status;

    @Schema(description = "The list of orders associated with the court")
    private List<OrderDTO> orderList;

}
