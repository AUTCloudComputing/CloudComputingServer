package ac.aut.CloudComputing.bookingsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import javax.annotation.PostConstruct;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@ComponentScan(basePackages = {  "ac.aut.CloudComputing.bookingsystem" })

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // Start the Spring context
    }

}