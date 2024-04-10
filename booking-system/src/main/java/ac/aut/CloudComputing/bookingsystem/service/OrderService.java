package ac.aut.CloudComputing.bookingsystem.service;

import java.util.List;

import ac.aut.CloudComputing.bookingsystem.dto.OrderRequest;
import ac.aut.CloudComputing.bookingsystem.model.Order;

public interface  OrderService {

	List<Order> getAllOrders();
	
    Order getOrderById(String orderId);
    
    Order createOrder(OrderRequest request);
    
    Order updateOrder(String orderId, OrderRequest request);
    
    void deleteOrder(String orderId);
    
}

