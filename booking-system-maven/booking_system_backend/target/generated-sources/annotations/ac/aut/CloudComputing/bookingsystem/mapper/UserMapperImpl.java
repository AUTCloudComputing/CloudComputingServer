package ac.aut.CloudComputing.bookingsystem.mapper;

import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T17:24:39+1200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDetailsDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        userDetailsDTO.setId( user.getId() );
        userDetailsDTO.setUserName( user.getUserName() );
        userDetailsDTO.setEmail( user.getEmail() );
        userDetailsDTO.setRole( user.getRole() );
        userDetailsDTO.setPassword( user.getPassword() );
        userDetailsDTO.setProfileImageS3Key( user.getProfileImageS3Key() );
        userDetailsDTO.setStatus( user.getStatus() );

        return userDetailsDTO;
    }

    @Override
    public User userRegisterDTOToUser(UserRegisterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUserName( dto.getUserName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );

        return user;
    }

    @Override
    public User userDetailsDTOToUser(UserDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setRole( dto.getRole() );
        user.setProfileImageS3Key( dto.getProfileImageS3Key() );
        user.setStatus( dto.getStatus() );

        return user;
    }
}
