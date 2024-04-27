package ac.aut.CloudComputing.bookingsystem.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository; 
import ac.aut.CloudComputing.bookingsystem.model.Order;

@EnableScan
public interface OrderRepository extends CrudRepository<Order, String> {
    // Define custom query methods if needed
}
