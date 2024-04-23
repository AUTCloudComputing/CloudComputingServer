package ac.aut.CloudComputing.bookingsystem.mapper;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.model.Order;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-23T14:14:42+1200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO OrderToOrderDTO(Order Order) {
        if ( Order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setAmount( Order.getAmount() );
        orderDTO.setDescription( Order.getDescription() );
        orderDTO.setId( Order.getId() );
        orderDTO.setUserId( Order.getUserId() );

        return orderDTO;
    }
}
