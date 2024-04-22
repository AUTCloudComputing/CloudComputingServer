package ac.aut.CloudComputing.bookingsystem.repository;
 
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.aut.CloudComputing.bookingsystem.model.User;

@Repository 
//@EnableScan
public interface UserRepository extends CrudRepository<User, String> { 
    Optional<User> findByUserName(String userName); // Update method name to follow Spring Data conventions
    // Other custom query methods...
}
