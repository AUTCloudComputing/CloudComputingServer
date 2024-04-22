package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.aut.CloudComputing.bookingsystem.service.OrderService;
import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.model.Order;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

@Service
public class OrderServiceImpl implements OrderService{

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public OrderServiceImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
    

    @Override
    public List<OrderDTO> getAllOrders() {
    	
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<Order> Orders = dynamoDBMapper.scan(Order.class, scanExpression);
        return Orders.stream().map(this::convertToDTO).collect(Collectors.toList()); 
    }

    @Override
    public OrderDTO getOrderById(String id) {
    	Order order = dynamoDBMapper.load(Order.class, id);
        return convertToDTO(order); 
    }

    @Override
    public OrderDTO createOrder(OrderDTO dto) {
    	  Order Order = new Order();
          BeanUtils.copyProperties(dto, Order);

          dynamoDBMapper.save(Order);

          return convertToDTO(Order);
          
    }

    @Override
    public OrderDTO updateOrder(String id, OrderDTO dto) {
    	  Order Order = dynamoDBMapper.load(Order.class, id);
          BeanUtils.copyProperties(dto, Order);

          dynamoDBMapper.save(Order);

          return convertToDTO(Order);
    }

    @Override
    public void deleteOrder(String id) {
    	  Order Order = dynamoDBMapper.load(Order.class, id);
          if (Order != null) {
              dynamoDBMapper.delete(Order);
          }
    }


    private OrderDTO convertToDTO(Order Order) {
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(Order, dto);
        return dto;
    }
 
}

