package ac.aut.CloudComputing.bookingsystem.repository;
 

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import ac.aut.CloudComputing.bookingsystem.model.User;

@EnableScan
public interface UserRepository extends DynamoDBCrudRepository<User, String> {
    List<User> findByUsername(String username);
    // Other custom query methods...
}
