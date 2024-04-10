package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.aut.CloudComputing.bookingsystem.repository.OrderRepository;
import ac.aut.CloudComputing.bookingsystem.service.OrderService;
import ac.aut.CloudComputing.bookingsystem.dto.OrderRequest;
import ac.aut.CloudComputing.bookingsystem.model.Order;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
 
    

    @Override
    public List<Order> getAllOrders() {
        // Implement logic to get all orders
		return null;
    }

    @Override
    public Order getOrderById(String orderId) {
        // Implement logic to get an order by ID
		return null;
    }

    @Override
    public Order createOrder(OrderRequest request) {
        // Implement logic to create an order
		return null;
    }

    @Override
    public Order updateOrder(String orderId, OrderRequest request) {
        // Implement logic to update an order
		return null;
    }

    @Override
    public void deleteOrder(String orderId) {
        // Implement logic to delete an order
    }


 
}

