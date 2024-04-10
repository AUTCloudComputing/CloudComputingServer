package ac.aut.CloudComputing.bookingsystem.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import ac.aut.CloudComputing.bookingsystem.model.Order;

@EnableScan
public interface OrderRepository extends DynamoDBCrudRepository<Order, String> {
    // Define custom query methods if needed
}
