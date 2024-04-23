package ac.aut.CloudComputing.bookingsystem.service;

import java.io.IOException;
import java.util.List;

import ac.aut.CloudComputing.bookingsystem.dto.CourtReqDTO;
import ac.aut.CloudComputing.bookingsystem.dto.CourtRspDTO; 

public interface  CourtService {

	List<CourtRspDTO> getAllCourts();
	
	CourtRspDTO getCourtById(String courtId);
    
	CourtRspDTO createCourt(CourtReqDTO request) throws IOException;
    
	CourtRspDTO updateCourt(String courtId, CourtReqDTO request) throws IOException;
    
    void deleteCourt(String courtId);
    

     void clear() ;
}

