package ac.aut.CloudComputing.bookingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import ac.aut.CloudComputing.bookingsystem.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Arrays; 

@Configuration 
@EnableWebSecurity 
@RequiredArgsConstructor
public class SecurityConfiguration  {
	
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
 
    
	/*
	 * , "/api/users/register", "/api/users/login"
	 */
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {   
         http.csrf(csrf -> csrf
                .disable())
                .authorizeHttpRequests(requests -> requests
                        .antMatchers("/auth/**",
                        		"/api/users/register", "/api/users/login",
                                "/swagger-ui/**",
                                "/swagger-ui/")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); 

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
 
		 // 设置允许的来源
		 configuration.setAllowedOrigins(Arrays.asList("http://localhost:8082"));
		 // 设置允许的方法
		 configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		 // 设置允许的头部信息
		 configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
     

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",configuration);

        return source;
    }
}
