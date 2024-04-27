package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils; 
import org.springframework.stereotype.Service;
 
import ac.aut.CloudComputing.bookingsystem.service.CourtService;
import ac.aut.CloudComputing.bookingsystem.service.S3Service;
import lombok.RequiredArgsConstructor;
import ac.aut.CloudComputing.bookingsystem.dto.CourtReqDTO;
import ac.aut.CloudComputing.bookingsystem.dto.CourtRspDTO;
import ac.aut.CloudComputing.bookingsystem.mapper.CourtMapper;
import ac.aut.CloudComputing.bookingsystem.model.Court;
import ac.aut.CloudComputing.bookingsystem.repository.CourtRepository; 

@Service
@RequiredArgsConstructor 
public class CourtServiceImpl implements CourtService {
 
    private final CourtRepository courtRepository; 
    private final S3Service s3Service;
 

    @Override
    public List<CourtRspDTO> getAllCourts() {
    	
    	Iterable<Court> courtsIterable = courtRepository.findAll();
        return StreamSupport.stream(courtsIterable.spliterator(), false)
                .map(CourtMapper.INSTANCE::Court2CourtRspDTO)
                .collect(Collectors.toList());
    }
    


    @Override
    public void clear() {
    	courtRepository.deleteAll();
    }
 

    @Override
    public CourtRspDTO getCourtById(String id) {
        return courtRepository.findById(id)
                .map(CourtMapper.INSTANCE::Court2CourtRspDTO)
                .orElse(null);
    }

    @Override
    public CourtRspDTO createCourt(CourtReqDTO dto) throws IOException {
        Court court = new Court();
        BeanUtils.copyProperties(dto, court);
        
        // Upload profile image to S3
		if(dto.getImageFile()!=null) {
			  String imageUrl = s3Service.uploadFile(dto.getImageFile());
			  court.setImage(imageUrl);
		}
		 
        court = courtRepository.save(court);
        return CourtMapper.INSTANCE.Court2CourtRspDTO(court);
    }

    @Override
    public CourtRspDTO updateCourt(String id, CourtReqDTO dto) throws IOException {
        Court court = courtRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Court found with id: " + id));
        BeanUtils.copyProperties(dto, court);

        // Upload profile image to S3
		if(dto.getImageFile()!=null) {
			  String imageUrl = s3Service.uploadFile(dto.getImageFile());
			  court.setImage(imageUrl);
		}
		
        court = courtRepository.save(court);
        return CourtMapper.INSTANCE.Court2CourtRspDTO(court);
    }

    @Override
    public void deleteCourt(String id) {
        courtRepository.deleteById(id);
    }
}

