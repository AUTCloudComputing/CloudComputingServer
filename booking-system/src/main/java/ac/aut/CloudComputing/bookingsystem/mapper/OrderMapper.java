package ac.aut.CloudComputing.bookingsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.model.Court;
import ac.aut.CloudComputing.bookingsystem.model.Order;
import ac.aut.CloudComputing.bookingsystem.model.User;

@Mapper
public interface OrderMapper { 
	
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class); 

	//output
	@Mapping(source = "user", target = "user")
	@Mapping(source = "court.id", target = "courtId")
	OrderDTO order2OrderDTO(Order order); 
	
	default UserDetailsDTO mapUser(User user) {
	    
		 if (user == null) {
	            return null;
	        }
	        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
	        userDetailsDTO.setId(user.getId());
	        userDetailsDTO.setUserName(user.getUserName());
	        // 其他属性的转换逻辑...
	        return userDetailsDTO;
	}
	
	default String mapCourtId(Court court) {
	    // 返回 Court 对象的 ID
	    return court != null ? court.getId() : null;
	}
	
	

	//input logic is in service, when create or update
	
     
     
}
