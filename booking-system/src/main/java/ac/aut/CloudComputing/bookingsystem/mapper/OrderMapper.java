package ac.aut.CloudComputing.bookingsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO; 
import ac.aut.CloudComputing.bookingsystem.model.Order;

@Mapper
public interface OrderMapper {
	
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
 
    OrderDTO OrderToOrderDTO(Order Order);
     
     
     
}
