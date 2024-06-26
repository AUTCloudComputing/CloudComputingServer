package ac.aut.CloudComputing.bookingsystem.config;
 

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.mapper.UserMapper;
import ac.aut.CloudComputing.bookingsystem.model.User;
import ac.aut.CloudComputing.bookingsystem.repository.UserRepository;
import ac.aut.CloudComputing.bookingsystem.service.UserService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    private final UserRepository userRepository;

 

    @Bean
    public UserDetailsService userDetailsService() {
    	 
    	// this code is hard to debug 
    	
//    	 return username -> userRepository.findByUserName(username)
// 		        .map(user -> UserMapper.INSTANCE.userToUserDTO(user))
//    	                .orElseThrow(() -> new UsernameNotFoundException("User not found")); 
    	 
    	 return username -> {
    		    Optional<User> userOptional = userRepository.findByUserName(username);
    		    if (userOptional.isPresent()) {
    		        User user = userOptional.get();      		        
    		        UserDetailsDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user); 
    		        return userDTO;
    		    } else { 
    		        throw new UsernameNotFoundException("User not found");
    		    }
    		};
    	 
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}


//https://github.com/tericcabrel/blog-tutorials/blob/main/springboot-jwt-auth/src/main/java/com/tericcabrel/authapi/configs/ApplicationConfiguration.java
