package ac.aut.CloudComputing.bookingsystem.controller;

import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO; 
import ac.aut.CloudComputing.bookingsystem.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/orders")
@Api(tags = "Order Management")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ApiOperation(value = "Get all orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
    	List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    @ApiOperation(value = "Create an order")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody @ApiParam("Order details") OrderDTO orderRequest) {
    	OrderDTO order = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get order by ID")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable @ApiParam("Order ID") String orderId) {
    	OrderDTO order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an order")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable @ApiParam("Order ID") String orderId, @RequestBody @ApiParam("Updated order details") OrderDTO orderRequest) {
    	OrderDTO updatedOrder = orderService.updateOrder(orderId, orderRequest);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an order")
    public ResponseEntity<Void> deleteOrder(@PathVariable @ApiParam("Order ID") String orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
