package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.DestinationDTO;
import lk.ijse.smarttravelapi.dto.HotelDTO;
import lk.ijse.smarttravelapi.entity.Destination;
import lk.ijse.smarttravelapi.entity.Hotel;
import lk.ijse.smarttravelapi.repository.DestinationRepository;
import lk.ijse.smarttravelapi.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationServiceIMPL implements DestinationService {

    private final DestinationRepository destinationRepository;
    private final HotelRepository hotelRepository;

    @Override
    public DestinationDTO saveDestination(DestinationDTO dto) {

        Destination dest = Destination.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .build();

        // Database eke save krnwa
        Destination savedDest = destinationRepository.save(dest);


        dto.setId(savedDest.getId());
        return dto;
    }

    @Override
    public List<DestinationDTO> getAllDestinations() {

        return destinationRepository.findAll().stream()
                .map(dest -> DestinationDTO.builder()
                        .id(dest.getId())
                        .name(dest.getName())
                        .description(dest.getDescription())
                        .image(dest.getImage())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public DestinationDTO getDestinationById(Long id) {
        Destination dest = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found"));


        List<Hotel> hotels = hotelRepository.findByDestination(dest.getName());

        List<HotelDTO> hotelDTOs = hotels.stream()
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

        DestinationDTO dto = DestinationDTO.builder()
                .id(dest.getId())
                .name(dest.getName())
                .description(dest.getDescription())
                .image(dest.getImage())
                .build();

        dto.setHotels(hotelDTOs);
        return dto;
    }

    @Override
    public void deleteDestination(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new RuntimeException("Destination not found with id: " + id);
        }
        destinationRepository.deleteById(id);
    }
}