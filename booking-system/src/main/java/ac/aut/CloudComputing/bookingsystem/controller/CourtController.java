package ac.aut.CloudComputing.bookingsystem.controller;

import ac.aut.CloudComputing.bookingsystem.dto.CourtDTO; 
import ac.aut.CloudComputing.bookingsystem.service.CourtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<CourtDTO>> getAllCourts() {  
    	List<CourtDTO> courts = courtService.getAllCourts();
        return ResponseEntity.ok(courts);
    } 

    @PostMapping
    @ApiOperation(value = "Create an court")
    public ResponseEntity<CourtDTO> createCourt(@RequestBody @ApiParam("court details") CourtDTO courtRequest) {
    	CourtDTO court = courtService.createCourt(courtRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(court);
    }


    @GetMapping("/clear")
    public ResponseEntity<Void> clear() {

    	courtService.clear();
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{courtId}")
    @ApiOperation(value = "Get court by ID")
    public ResponseEntity<CourtDTO> getcourtById(@PathVariable @ApiParam("court ID") String courtId) {
    	CourtDTO court = courtService.getCourtById(courtId);
        if (court != null) {
            return ResponseEntity.ok(court);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{courtId}")
    @ApiOperation(value = "Update an court")
    public ResponseEntity<CourtDTO> updateCourt(@PathVariable @ApiParam("court ID") String courtId, @RequestBody @ApiParam("Updated court details") CourtDTO courtRequest) {
    	CourtDTO updatedcourt = courtService.updateCourt(courtId, courtRequest);
        if (updatedcourt != null) {
            return ResponseEntity.ok(updatedcourt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{courtId}")
    @ApiOperation(value = "Delete an court")
    public ResponseEntity<Void> deleteCourt(@PathVariable @ApiParam("court ID") String courtId) {
        courtService.deleteCourt(courtId);
        return ResponseEntity.noContent().build();
    }
}
