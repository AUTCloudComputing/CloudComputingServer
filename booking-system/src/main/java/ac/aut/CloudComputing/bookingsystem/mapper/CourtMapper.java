package ac.aut.CloudComputing.bookingsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ac.aut.CloudComputing.bookingsystem.dto.CourtDTO; 
import ac.aut.CloudComputing.bookingsystem.model.Court;

@Mapper
public interface CourtMapper {
	
    CourtMapper INSTANCE = Mappers.getMapper(CourtMapper.class);
 
    CourtDTO CourtToCourtDTO(Court court);
     
     
     
}
