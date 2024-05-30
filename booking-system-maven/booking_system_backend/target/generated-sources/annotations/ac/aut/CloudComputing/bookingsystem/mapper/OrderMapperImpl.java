package ac.aut.CloudComputing.bookingsystem.mapper;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.model.Order;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-31T07:58:55+1200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO order2OrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBusinessId( order.getBusinessId() );
        orderDTO.setCancelDay( order.getCancelDay() );
        orderDTO.setCourtId( order.getCourtId() );
        orderDTO.setCreateDay( order.getCreateDay() );
        orderDTO.setDescription( order.getDescription() );
        orderDTO.setId( order.getId() );
        orderDTO.setOrderDay( order.getOrderDay() );
        orderDTO.setStatus( order.getStatus() );
        orderDTO.setUserId( order.getUserId() );

        return orderDTO;
    }
}
