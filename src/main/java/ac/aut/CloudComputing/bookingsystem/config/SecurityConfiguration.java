package ac.aut.CloudComputing.bookingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays; 

@Configuration 
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(
        JwtAuthenticationFilter jwtAuthenticationFilter,
        AuthenticationProvider authenticationProvider
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
    
    
	/*
	 * , "/api/users/register", "/api/users/login"
	 */
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
    	
    	 http.csrf().disable()
         .authorizeRequests()
             .antMatchers("/**").permitAll() // 允许所有请求
             .and()
         .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
         .authenticationProvider(authenticationProvider)
         .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

     return http.build();
//     
//         http.csrf(csrf -> csrf
//                .disable())
//                .authorizeHttpRequests(requests -> requests
//                        .antMatchers("/auth/**")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
//                .sessionManagement(management -> management
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); 
//
//        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
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
