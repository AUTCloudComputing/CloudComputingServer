package ac.aut.CloudComputing.bookingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderDTO {

    @Schema(description = "The unique identifier of the order")
    private String id;

    @Schema(description = "The user ID associated with the order")
    private String userId;

    @Schema(description = "The description of the order")
    private String description;

    @Schema(description = "The amount of the order", example = "100.0")
    private double amount;

}
