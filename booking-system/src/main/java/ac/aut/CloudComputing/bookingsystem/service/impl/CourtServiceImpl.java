package ac.aut.CloudComputing.bookingsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils; 
import org.springframework.stereotype.Service;
 
import ac.aut.CloudComputing.bookingsystem.service.CourtService; 
import lombok.RequiredArgsConstructor;
import ac.aut.CloudComputing.bookingsystem.dto.CourtDTO;
import ac.aut.CloudComputing.bookingsystem.mapper.CourtMapper;
import ac.aut.CloudComputing.bookingsystem.model.Court;
import ac.aut.CloudComputing.bookingsystem.repository.CourtRepository; 

@Service
@RequiredArgsConstructor 
public class CourtServiceImpl implements CourtService {
 
    private final CourtRepository courtRepository; 
 

    @Override
    public List<CourtDTO> getAllCourts() {
    	
    	Iterable<Court> courtsIterable = courtRepository.findAll();
        return StreamSupport.stream(courtsIterable.spliterator(), false)
                .map(CourtMapper.INSTANCE::CourtToCourtDTO)
                .collect(Collectors.toList());
    }
    


    @Override
    public void clear() {
    	courtRepository.deleteAll();
    }
 

    @Override
    public CourtDTO getCourtById(String id) {
        return courtRepository.findById(id)
                .map(CourtMapper.INSTANCE::CourtToCourtDTO)
                .orElse(null);
    }

    @Override
    public CourtDTO createCourt(CourtDTO dto) {
        Court court = new Court();
        BeanUtils.copyProperties(dto, court);
        court = courtRepository.save(court);
        return CourtMapper.INSTANCE.CourtToCourtDTO(court);
    }

    @Override
    public CourtDTO updateCourt(String id, CourtDTO dto) {
        Court court = courtRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Court found with id: " + id));
        BeanUtils.copyProperties(dto, court);
        court = courtRepository.save(court);
        return CourtMapper.INSTANCE.CourtToCourtDTO(court);
    }

    @Override
    public void deleteCourt(String id) {
        courtRepository.deleteById(id);
    }
}

