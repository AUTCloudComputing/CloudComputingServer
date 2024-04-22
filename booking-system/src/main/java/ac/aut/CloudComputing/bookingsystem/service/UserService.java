package ac.aut.CloudComputing.bookingsystem.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserLoginDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO; 

public interface UserService {
	UserDetailsDTO registerUser(UserRegisterDTO request) throws IOException ;
	UserDetailsDTO loginUser(UserLoginDTO request); 

	List<UserDetailsDTO> allUsers();
    Optional<UserDetailsDTO> findByUserName(String userName);
}