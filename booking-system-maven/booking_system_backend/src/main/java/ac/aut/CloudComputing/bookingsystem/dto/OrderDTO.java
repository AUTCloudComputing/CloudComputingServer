package ac.aut.CloudComputing.bookingsystem.dto;

import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.model.Court;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Schema(description = "The order")
@Data
public class OrderDTO {

    @Schema(description = "The unique identifier of the order")
    private String id;
 
    @Schema(description = "The user associated with the order")
    private UserDetailsDTO user;
    

    @Schema(description = "The court ID associated with the order")
    private String courtId; 
 
    @Schema(description = "The order day")
    private Date orderDay;

    @Schema(description = "The cancel day")
    private Date cancelDay;

    @Schema(description = "The create day")
    private Date createDay;

    @Schema(description = "The business ID associated with the order")
    private String businessId;

    @Schema(description = "The description of the order")
    private String description;

    @Schema(description = "The status of the order", example = "1")
    private int status;

}
