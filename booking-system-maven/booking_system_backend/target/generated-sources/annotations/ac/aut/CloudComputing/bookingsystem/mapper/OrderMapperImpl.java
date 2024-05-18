package ac.aut.CloudComputing.bookingsystem.mapper;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.model.Order;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T13:52:28+1200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO order2OrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setUserId( order.getUserId() );
        orderDTO.setCourtId( order.getCourtId() );
        orderDTO.setOrderDay( order.getOrderDay() );
        orderDTO.setCancelDay( order.getCancelDay() );
        orderDTO.setCreateDay( order.getCreateDay() );
        orderDTO.setBusinessId( order.getBusinessId() );
        orderDTO.setDescription( order.getDescription() );
        orderDTO.setStatus( order.getStatus() );

        return orderDTO;
    }
}
