package ac.aut.CloudComputing.bookingsystem.service;

import java.util.List;

import ac.aut.CloudComputing.bookingsystem.dto.CourtDTO; 

public interface  CourtService {

	List<CourtDTO> getAllCourts();
	
	CourtDTO getCourtById(String courtId);
    
	CourtDTO createCourt(CourtDTO request);
    
	CourtDTO updateCourt(String courtId, CourtDTO request);
    
    void deleteCourt(String courtId);
    

     void clear() ;
}

