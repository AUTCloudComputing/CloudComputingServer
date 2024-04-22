package ac.aut.CloudComputing.bookingsystem.controller;

 
 
import java.io.IOException;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.aut.CloudComputing.bookingsystem.dto.LoginResponse;
import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.service.JwtService;
import ac.aut.CloudComputing.bookingsystem.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity; 
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
	
    private final JwtService jwtService;
    private final UserService userService;
 

    @PostMapping("/signup")
    public ResponseEntity<UserDetailsDTO> register(@RequestBody UserRegisterDTO registerUserDto) throws IOException   {
        UserDetailsDTO registeredUser = userService.registerUser(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserLoginDTO loginUserDto) {
    	
        UserDetailsDTO authenticatedUser = userService.loginUser(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
     
}