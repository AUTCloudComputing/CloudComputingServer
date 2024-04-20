package ac.aut.CloudComputing.bookingsystem.dto;
 

import lombok.Data;


@Data
public class OrderDTO { 
    private String Id; 
    
    private String userId; 
     
    private String description;
     
    private double amount;
 
}

