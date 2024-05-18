package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils; 
import org.springframework.stereotype.Service;

import ac.aut.CloudComputing.bookingsystem.service.CourtService;
import ac.aut.CloudComputing.bookingsystem.service.OrderService;
import ac.aut.CloudComputing.bookingsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import ac.aut.CloudComputing.bookingsystem.dto.CourtRspDTO;
import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.mapper.CourtMapper;
import ac.aut.CloudComputing.bookingsystem.mapper.OrderMapper;
import ac.aut.CloudComputing.bookingsystem.mapper.UserMapper;
import ac.aut.CloudComputing.bookingsystem.model.Order;
import ac.aut.CloudComputing.bookingsystem.repository.OrderRepository; 

@Service
@RequiredArgsConstructor 
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;  
    private final CourtService courtService;
    private final UserService userService;

    @Override
    public List<OrderDTO> getAllOrders() {
    	
    	Iterable<Order> ordersIterable = orderRepository.findAll();
        return StreamSupport.stream(ordersIterable.spliterator(), false)
                .map(OrderMapper.INSTANCE::order2OrderDTO)
                .collect(Collectors.toList());
    }
    


    @Override
    public void clear() {
    	orderRepository.deleteAll();
    }
 

    @Override
    public OrderDTO getOrderById(String id) {
        return orderRepository.findById(id)
                .map(OrderMapper.INSTANCE::order2OrderDTO)
                .orElse(null);
    }

    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        Order order = new Order();
        BeanUtils.copyProperties(dto, order);


        

        if(dto.getCourtId()!=null) {
//	        CourtRspDTO courtDto= courtService.getCourtById(dto.getCourtId());
//	        if(courtDto!=null) {
	        	order.setCourtId(dto.getCourtId());
//	        }
        }
        
        if(dto.getUserId()!=null) {
//	        UserDetailsDTO userDto= userService.getUserById(dto.getUserId());
//	        if(userDto!=null) {
	        	order.setUserId(dto.getUserId());
//	        }
        }
        
        
        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.order2OrderDTO(order);
    }

    @Override
    public OrderDTO updateOrder(String id, OrderDTO dto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Order found with id: " + id));
        BeanUtils.copyProperties(dto, order);


        if(dto.getCourtId()!=null) {
//	        CourtRspDTO courtDto= courtService.getCourtById(dto.getCourtId());
//	        if(courtDto!=null) {
            order.setCourtId(dto.getCourtId());
//	        }
        }
        
        if(dto.getUserId()!=null  ) {
//	        UserDetailsDTO userDto= userService.getUserById(dto.getUserId().getId());
//	        if(userDto!=null) {
	        	order.setUserId(dto.getUserId());
//	        }
        }
        
        
        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.order2OrderDTO(order);
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}

