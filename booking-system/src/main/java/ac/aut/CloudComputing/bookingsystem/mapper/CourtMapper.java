package ac.aut.CloudComputing.bookingsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ac.aut.CloudComputing.bookingsystem.dto.CourtReqDTO;
import ac.aut.CloudComputing.bookingsystem.dto.CourtRspDTO;
import ac.aut.CloudComputing.bookingsystem.model.Court;

@Mapper
public interface CourtMapper {
	
    CourtMapper INSTANCE = Mappers.getMapper(CourtMapper.class);

    CourtRspDTO Court2CourtRspDTO(Court court);
    Court CourtReqDTO2Court(CourtReqDTO req);
     
     
     
}
