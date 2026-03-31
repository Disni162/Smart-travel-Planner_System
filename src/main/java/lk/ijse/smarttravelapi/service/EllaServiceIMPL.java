package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.DesEllaDTO;
import lk.ijse.smarttravelapi.entity.DesElla;
import lk.ijse.smarttravelapi.repository.EllaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EllaServiceIMPL implements EllaService {

    private final EllaRepository ellaRepository;


    @Override
    public DesEllaDTO saveHotel(DesEllaDTO dto) {

        DesElla hotel = new DesElla(
                dto.getId(),
                dto.getName(),
                dto.getDestination(),
                dto.getDescription(),
                dto.getImage(),
                dto.getType(),
                dto.getPricePerNight()
        );

        ellaRepository.save(hotel);

        return dto;
    }


    @Override
    public List<DesEllaDTO> getAllHotels() {

        return ellaRepository.findAll()
                .stream()
                .map(h -> new DesEllaDTO(
                        h.getId(),
                        h.getName(),
                        h.getDestination(),
                        h.getDescription(),
                        h.getImage(),
                        h.getType(),
                        h.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteHotel(Long id) {
        ellaRepository.deleteById(id);
    }


    @Override
    public List<DesEllaDTO> getHotelsByDestination(String destination) {

        return ellaRepository.findByDestination(destination)
                .stream()
                .map(h -> new DesEllaDTO(
                        h.getId(),
                        h.getName(),
                        h.getDestination(),
                        h.getDescription(),
                        h.getImage(),
                        h.getType(),
                        h.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }
}
