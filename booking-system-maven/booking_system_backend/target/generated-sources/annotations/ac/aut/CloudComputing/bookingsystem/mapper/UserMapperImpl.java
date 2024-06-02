package ac.aut.CloudComputing.bookingsystem.mapper;

import ac.aut.CloudComputing.bookingsystem.dto.UserDetailsDTO;
import ac.aut.CloudComputing.bookingsystem.dto.UserRegisterDTO;
import ac.aut.CloudComputing.bookingsystem.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-31T07:58:55+1200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDetailsDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        userDetailsDTO.setEmail( user.getEmail() );
        userDetailsDTO.setId( user.getId() );
        userDetailsDTO.setPassword( user.getPassword() );
        userDetailsDTO.setProfileImageS3Key( user.getProfileImageS3Key() );
        userDetailsDTO.setRole( user.getRole() );
        userDetailsDTO.setStatus( user.getStatus() );
        userDetailsDTO.setUserName( user.getUserName() );

        return userDetailsDTO;
    }

    @Override
    public User userRegisterDTOToUser(UserRegisterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setUserName( dto.getUserName() );

        return user;
    }

    @Override
    public User userDetailsDTOToUser(UserDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( dto.getEmail() );
        user.setId( dto.getId() );
        user.setPassword( dto.getPassword() );
        user.setProfileImageS3Key( dto.getProfileImageS3Key() );
        user.setRole( dto.getRole() );
        user.setStatus( dto.getStatus() );

        return user;
    }
}
