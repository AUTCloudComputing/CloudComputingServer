package ac.aut.CloudComputing.bookingsystem.controller;
 
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.aut.CloudComputing.bookingsystem.dto.LoginResponse;
import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.service.JwtService;
import ac.aut.CloudComputing.bookingsystem.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
 
@RestController 
@RequiredArgsConstructor
@RequestMapping("/api/users") 
public class UserController {
 
	    private final UserService userService;
	 

	    @PostMapping("/register")
	    public ResponseEntity<LoginResponse> register(@RequestBody UserRegisterDTO registerUserDto) throws IOException   {
	    	LoginResponse r = userService.registerUser(registerUserDto);

	        return ResponseEntity.ok(r);
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserLoginDTO loginUserDto) {
	    	
	    	LoginResponse r = userService.loginUser(loginUserDto); 
	        return ResponseEntity.ok(r);
	    }
 

	    @GetMapping("/me")
	    public ResponseEntity<UserDetailsDTO> authenticatedUser() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        UserDetailsDTO currentUser = (UserDetailsDTO) authentication.getPrincipal();

	        return ResponseEntity.ok(currentUser);
	    }
	    
	    //@PreAuthorize("hasRole(‘ADMIN’)")
	    //@PreAuthorize("hasAuthority('ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<UserDetailsDTO>> allUsers() {
	        List <UserDetailsDTO> users = userService.allUsers();

	        return ResponseEntity.ok(users);
	    }
    
}
