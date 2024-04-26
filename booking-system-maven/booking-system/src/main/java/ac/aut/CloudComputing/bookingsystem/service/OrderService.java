package ac.aut.CloudComputing.bookingsystem.service;

import java.util.List;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO; 

public interface  OrderService {

	List<OrderDTO> getAllOrders();
	
	OrderDTO getOrderById(String orderId);
    
	OrderDTO createOrder(OrderDTO request);
    
	OrderDTO updateOrder(String orderId, OrderDTO request);
    
    void deleteOrder(String orderId);
    

     void clear() ;
}

