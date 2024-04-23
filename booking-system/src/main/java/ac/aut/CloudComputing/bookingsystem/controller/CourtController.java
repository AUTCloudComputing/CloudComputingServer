package ac.aut.CloudComputing.bookingsystem.controller;

import ac.aut.CloudComputing.bookingsystem.dto.CourtReqDTO;
import ac.aut.CloudComputing.bookingsystem.dto.CourtRspDTO; 
import ac.aut.CloudComputing.bookingsystem.service.CourtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/courts")
@Api(tags = "court Management")
public class CourtController {

    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }
 
    @GetMapping
    @ApiOperation(value = "Get all courts")
    public ResponseEntity<List<CourtRspDTO>> getAllCourts() {  
    	List<CourtRspDTO> courts = courtService.getAllCourts();
        return ResponseEntity.ok(courts);
    } 

    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping
    @ApiOperation(value = "Create an court")
    public ResponseEntity<CourtRspDTO> createCourt(

            @RequestParam("courtName") String courtName,
            @RequestParam("imageFile") MultipartFile image,
            @RequestParam("status") int status,
            @RequestParam("description") String description
            ) throws IOException {
    	
    	 CourtReqDTO courtRequest = new CourtReqDTO();
    	    courtRequest.setCourtName(courtName);
    	    courtRequest.setImageFile(image);
    	    courtRequest.setStatus(status);
    	    courtRequest.setDescription(description);
    	    
    	CourtRspDTO court = courtService.createCourt(courtRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(court);
    }


    @PreAuthorize("hasRole('ADMIN')") 
    @GetMapping("/clear")
    public ResponseEntity<Void> clear() {

    	courtService.clear();
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{courtId}")
    @ApiOperation(value = "Get court by ID")
    public ResponseEntity<CourtRspDTO> getcourtById(@PathVariable @ApiParam("court ID") String courtId) {
    	CourtRspDTO court = courtService.getCourtById(courtId);
        if (court != null) {
            return ResponseEntity.ok(court);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("/{courtId}")
    @ApiOperation(value = "Update an court")
    public ResponseEntity<CourtRspDTO> updateCourt(@PathVariable @ApiParam("court ID") String courtId
    		,
            @RequestParam("courtName") String courtName,
            @RequestParam("imageFile") MultipartFile image,
            @RequestParam("status") int status,
            @RequestParam("description") String description
            ) throws IOException {
    	
    	 CourtReqDTO courtRequest = new CourtReqDTO();
    	    courtRequest.setCourtName(courtName);
    	    courtRequest.setImageFile(image);
    	    courtRequest.setStatus(status);
    	    courtRequest.setDescription(description);
    	    
    	CourtRspDTO updatedcourt = courtService.updateCourt(courtId, courtRequest);
        if (updatedcourt != null) {
            return ResponseEntity.ok(updatedcourt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("/{courtId}")
    @ApiOperation(value = "Delete an court")
    public ResponseEntity<Void> deleteCourt(@PathVariable @ApiParam("court ID") String courtId) {
        courtService.deleteCourt(courtId);
        return ResponseEntity.noContent().build();
    }
}
