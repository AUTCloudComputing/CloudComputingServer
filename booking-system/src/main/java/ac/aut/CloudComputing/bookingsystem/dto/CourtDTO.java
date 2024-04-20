package ac.aut.CloudComputing.bookingsystem.dto;

import java.util.List;

import lombok.Data;


@Data
public class CourtDTO {
	private int id;
    private String courtName;
    private String image;
    private int status;
    private List<OrderDTO> orderList;
 
}

