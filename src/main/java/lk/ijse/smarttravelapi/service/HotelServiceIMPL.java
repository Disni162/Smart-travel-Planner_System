package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.HotelDTO;
import lk.ijse.smarttravelapi.entity.Hotel;
import lk.ijse.smarttravelapi.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceIMPL implements HotelService {

    private final HotelRepository hotelRepository;


    @Override
    public HotelDTO saveHotel(HotelDTO dto) {

        Hotel hotel = new Hotel(
                dto.getId(),
                dto.getName(),
                dto.getDestination(),
                dto.getDescription(),
                dto.getImage(),
                dto.getType(),
                dto.getPricePerNight()
        );

        hotelRepository.save(hotel);

        return dto;
    }


    @Override
    public List<HotelDTO> getAllHotels() {

        return hotelRepository.findAll()
                .stream()
                .map(h -> new HotelDTO(
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
        hotelRepository.deleteById(id);
    }


    @Override
    public List<HotelDTO> getHotelsByDestination(String destination) {

        return hotelRepository.findByDestination(destination)
                .stream()
                .map(h -> new HotelDTO(
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

