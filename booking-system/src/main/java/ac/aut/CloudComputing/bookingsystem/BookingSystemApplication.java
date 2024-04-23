package ac.aut.CloudComputing.bookingsystem;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.DefaultSecurityFilterChain; 
 
 
@SpringBootApplication
//@ComponentScan(basePackages = { "ac.aut.CloudComputing.bookingsystem.repository" }) 
@ComponentScan(basePackages = {  "ac.aut.CloudComputing.bookingsystem" }) 
public class BookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingSystemApplication.class, args); 

	}

	
}
