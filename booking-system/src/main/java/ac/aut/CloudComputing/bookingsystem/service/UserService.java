package ac.aut.CloudComputing.bookingsystem.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import ac.aut.CloudComputing.bookingsystem.dto.LoginResponse;
import ac.aut.CloudComputing.bookingsystem.dto.OrderDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO; 

public interface UserService {
	LoginResponse registerUser(UserRegisterDTO request) throws IOException ;
	LoginResponse loginUser(UserLoginDTO request); 

	List<UserDetailsDTO> allUsers();
    Optional<UserDetailsDTO> findByUserName(String userName);
    
    void clearUsers();
    UserDetailsDTO getUserById(String id);
}