package ac.aut.CloudComputing.bookingsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.model.User;

@Mapper
public interface UserMapper {
	
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
 
    UserDetailsDTO userToUserDTO(User user);
    
    User userRegisterDTOToUser(UserRegisterDTO dto);
     
     
}
