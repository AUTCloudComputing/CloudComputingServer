package ac.aut.CloudComputing.bookingsystem.repository;
 
 
import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import ac.aut.CloudComputing.bookingsystem.model.User;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByUsername(String username);
    // Other custom query methods...
}
