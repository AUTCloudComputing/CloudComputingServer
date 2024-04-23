package ac.aut.CloudComputing.bookingsystem.controller;

import ac.aut.CloudComputing.bookingsystem.dto.courtDTO; 
import ac.aut.CloudComputing.bookingsystem.service.courtService;
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

    private final courtService courtService;

    public CourtController(courtService courtService) {
        this.courtService = courtService;
    }

    @GetMapping
    @ApiOperation(value = "Get all courts")
    public ResponseEntity<List<courtDTO>> getAllcourts() {  
    	List<courtDTO> courts = courtService.getAllcourts();
        return ResponseEntity.ok(courts);
    } 

    @PostMapping
    @ApiOperation(value = "Create an court")
    public ResponseEntity<courtDTO> createcourt(@RequestBody @ApiParam("court details") courtDTO courtRequest) {
    	courtDTO court = courtService.createcourt(courtRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(court);
    }


    @GetMapping("/clear")
    public ResponseEntity<Void> clear() {

    	courtService.clear();
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{courtId}")
    @ApiOperation(value = "Get court by ID")
    public ResponseEntity<courtDTO> getcourtById(@PathVariable @ApiParam("court ID") String courtId) {
    	courtDTO court = courtService.getcourtById(courtId);
        if (court != null) {
            return ResponseEntity.ok(court);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{courtId}")
    @ApiOperation(value = "Update an court")
    public ResponseEntity<courtDTO> updatecourt(@PathVariable @ApiParam("court ID") String courtId, @RequestBody @ApiParam("Updated court details") courtDTO courtRequest) {
    	courtDTO updatedcourt = courtService.updatecourt(courtId, courtRequest);
        if (updatedcourt != null) {
            return ResponseEntity.ok(updatedcourt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{courtId}")
    @ApiOperation(value = "Delete an court")
    public ResponseEntity<Void> deletecourt(@PathVariable @ApiParam("court ID") String courtId) {
        courtService.deletecourt(courtId);
        return ResponseEntity.noContent().build();
    }
}
