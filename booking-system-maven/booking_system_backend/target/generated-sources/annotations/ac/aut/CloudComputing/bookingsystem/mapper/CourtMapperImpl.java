package ac.aut.CloudComputing.bookingsystem.mapper;

import ac.aut.CloudComputing.bookingsystem.dto.CourtReqDTO;
import ac.aut.CloudComputing.bookingsystem.dto.CourtRspDTO;
import ac.aut.CloudComputing.bookingsystem.model.Court;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-28T10:32:40+1200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
public class CourtMapperImpl implements CourtMapper {

    @Override
    public CourtRspDTO Court2CourtRspDTO(Court court) {
        if ( court == null ) {
            return null;
        }

        CourtRspDTO courtRspDTO = new CourtRspDTO();

        courtRspDTO.setId( court.getId() );
        courtRspDTO.setCourtName( court.getCourtName() );
        courtRspDTO.setImage( court.getImage() );
        courtRspDTO.setStatus( court.getStatus() );
        courtRspDTO.setDescription( court.getDescription() );

        return courtRspDTO;
    }

    @Override
    public Court CourtReqDTO2Court(CourtReqDTO req) {
        if ( req == null ) {
            return null;
        }

        Court court = new Court();

        court.setCourtName( req.getCourtName() );
        court.setDescription( req.getDescription() );
        court.setStatus( req.getStatus() );

        return court;
    }

    @Override
    public Court CourtRspDTO2Court(CourtRspDTO rsp) {
        if ( rsp == null ) {
            return null;
        }

        Court court = new Court();

        court.setId( rsp.getId() );
        court.setCourtName( rsp.getCourtName() );
        court.setImage( rsp.getImage() );
        court.setDescription( rsp.getDescription() );
        court.setStatus( rsp.getStatus() );

        return court;
    }
}
