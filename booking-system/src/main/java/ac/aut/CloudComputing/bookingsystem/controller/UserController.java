package ac.aut.CloudComputing.bookingsystem.controller;
 
import java.util.List;

import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping; 
 
@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "Endpoints for user registration and login") 
public class UserController {

	 private final UserService userService;

	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @GetMapping("/me")
	    public ResponseEntity<UserDetailsDTO> authenticatedUser() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        UserDetailsDTO currentUser = (UserDetailsDTO) authentication.getPrincipal();

	        return ResponseEntity.ok(currentUser);
	    }
	    
	    //@PreAuthorize("hasRole(‘ADMIN’)")
	    @PreAuthorize("hasAuthority('ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<UserDetailsDTO>> allUsers() {
	        List <UserDetailsDTO> users = userService.allUsers();

	        return ResponseEntity.ok(users);
	    }
    
}
