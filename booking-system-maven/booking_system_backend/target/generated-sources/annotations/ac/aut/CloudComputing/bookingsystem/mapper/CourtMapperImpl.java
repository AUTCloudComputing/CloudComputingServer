package ac.aut.CloudComputing.bookingsystem.mapper;

import ac.aut.CloudComputing.bookingsystem.dto.CourtReqDTO;
import ac.aut.CloudComputing.bookingsystem.dto.CourtRspDTO;
import ac.aut.CloudComputing.bookingsystem.model.Court;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-31T07:58:55+1200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class CourtMapperImpl implements CourtMapper {

    @Override
    public CourtRspDTO Court2CourtRspDTO(Court court) {
        if ( court == null ) {
            return null;
        }

        CourtRspDTO courtRspDTO = new CourtRspDTO();

        courtRspDTO.setCourtName( court.getCourtName() );
        courtRspDTO.setDescription( court.getDescription() );
        courtRspDTO.setId( court.getId() );
        courtRspDTO.setImage( court.getImage() );
        courtRspDTO.setStatus( court.getStatus() );

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

        court.setCourtName( rsp.getCourtName() );
        court.setDescription( rsp.getDescription() );
        court.setId( rsp.getId() );
        court.setImage( rsp.getImage() );
        court.setStatus( rsp.getStatus() );

        return court;
    }
}
