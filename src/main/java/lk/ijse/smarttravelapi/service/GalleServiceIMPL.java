package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.DestinationGalleDTO;
import lk.ijse.smarttravelapi.entity.Galle;
import lk.ijse.smarttravelapi.repository.GalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GalleServiceIMPL implements GalleService {

    private final GalleRepository galleRepository;

    @Override
    public DestinationGalleDTO saveGalleItem(DestinationGalleDTO dto) {
        // DTO to Entity mapping
        Galle galleItem = Galle.builder()
                .id(dto.getId())
                .name(dto.getName())
                .destination(dto.getDestination())
                .description(dto.getDescription())
                .image(dto.getImage())
                .type(dto.getType())
                .pricePerNight(dto.getPricePerNight())
                .build();

        galleRepository.save(galleItem);
        return dto;
    }

    @Override
    public List<DestinationGalleDTO> getAllGalleItems() {
        return galleRepository.findAll()
                .stream()
                .map(g -> new DestinationGalleDTO(
                        g.getId(),
                        g.getName(),
                        g.getDestination(),
                        g.getDescription(),
                        g.getImage(),
                        g.getType(),
                        g.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGalleItem(Long id) {
        galleRepository.deleteById(id);
    }

    @Override
    public List<DestinationGalleDTO> getItemsByDestination(String destination) {
        return galleRepository.findByDestination(destination)
                .stream()
                .map(g -> new DestinationGalleDTO(
                        g.getId(),
                        g.getName(),
                        g.getDestination(),
                        g.getDescription(),
                        g.getImage(),
                        g.getType(),
                        g.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }
}