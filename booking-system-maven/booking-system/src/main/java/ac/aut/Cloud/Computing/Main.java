package ac.aut.Cloud.Computing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {

    @Value("${aws.region}")
    private String region;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // Start the Spring context
    }

    @PostConstruct
    public void init() {
        System.out.println("Hello world! Confirmed that resource files work well");
        System.out.println("AWS Region = " + region);
    }
}