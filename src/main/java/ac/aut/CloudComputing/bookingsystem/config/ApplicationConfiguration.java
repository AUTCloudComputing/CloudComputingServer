package ac.aut.CloudComputing.bookingsystem.config;
 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ac.aut.CloudComputing.bookingsystem.mapper.UserMapper;
import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.repository.UserRepository;
import ac.aut.CloudComputing.bookingsystem.service.UserService;

@Configuration
public class ApplicationConfiguration {

    private final UserService userService;


    public ApplicationConfiguration(UserService userRepository) {
        this.userService = userRepository;
    }

    @Bean
    UserDetailsService userDetailsService() {
    	 
    	
    	 return username -> userService.findByUserName(username)
    	                .orElseThrow(() -> new UsernameNotFoundException("User not found")); 
    	 
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}

