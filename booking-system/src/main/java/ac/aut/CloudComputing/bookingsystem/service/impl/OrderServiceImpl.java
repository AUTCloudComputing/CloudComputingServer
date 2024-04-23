package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils; 
import org.springframework.stereotype.Service;
 
import ac.aut.CloudComputing.bookingsystem.service.OrderService; 
import lombok.RequiredArgsConstructor;
import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.mapper.OrderMapper;
import ac.aut.CloudComputing.bookingsystem.model.Order;
import ac.aut.CloudComputing.bookingsystem.repository.OrderRepository; 

@Service
@RequiredArgsConstructor 
public class OrderServiceImpl implements OrderService {
 
    private final OrderRepository orderRepository; 
 

    @Override
    public List<OrderDTO> getAllOrders() {
    	
    	Iterable<Order> ordersIterable = orderRepository.findAll();
        return StreamSupport.stream(ordersIterable.spliterator(), false)
                .map(OrderMapper.INSTANCE::OrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(String id) {
        return orderRepository.findById(id)
                .map(OrderMapper.INSTANCE::OrderToOrderDTO)
                .orElse(null);
    }

    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        Order order = new Order();
        BeanUtils.copyProperties(dto, order);
        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.OrderToOrderDTO(order);
    }

    @Override
    public OrderDTO updateOrder(String id, OrderDTO dto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Order found with id: " + id));
        BeanUtils.copyProperties(dto, order);
        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.OrderToOrderDTO(order);
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}

