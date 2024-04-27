package ac.aut.CloudComputing.bookingsystem.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository; 
import ac.aut.CloudComputing.bookingsystem.model.Court;

@EnableScan
public interface CourtRepository extends CrudRepository<Court, String> {
    // Define custom query methods if needed
}
