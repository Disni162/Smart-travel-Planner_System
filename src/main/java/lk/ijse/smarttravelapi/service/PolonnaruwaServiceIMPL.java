package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.PolonnaruwaDTO;
import lk.ijse.smarttravelapi.entity.Polonnaruwa;
import lk.ijse.smarttravelapi.repository.PolonnaruwaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolonnaruwaServiceIMPL implements PolonnaruwaService {

    private final PolonnaruwaRepository polonnaruwaRepository;

    @Override
    public PolonnaruwaDTO savePolonnaruwaItem(PolonnaruwaDTO dto) {

        Polonnaruwa polonItem = Polonnaruwa.builder()
                .id(dto.getId())
                .name(dto.getName())
                .destination(dto.getDestination())
                .description(dto.getDescription())
                .image(dto.getImage())
                .type(dto.getType())
                .pricePerNight(dto.getPricePerNight())
                .build();

        polonnaruwaRepository.save(polonItem);
        return dto;
    }

    @Override
    public List<PolonnaruwaDTO> getAllPolonnaruwaItems() {
        return polonnaruwaRepository.findAll()
                .stream()
                .map(p -> new PolonnaruwaDTO(
                        p.getId(),
                        p.getName(),
                        p.getDestination(),
                        p.getDescription(),
                        p.getImage(),
                        p.getType(),
                        p.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePolonnaruwaItem(Long id) {
        polonnaruwaRepository.deleteById(id);
    }

    @Override
    public List<PolonnaruwaDTO> getItemsByDestination(String destination) {
        return polonnaruwaRepository.findByDestination(destination)
                .stream()
                .map(p -> new PolonnaruwaDTO(
                        p.getId(),
                        p.getName(),
                        p.getDestination(),
                        p.getDescription(),
                        p.getImage(),
                        p.getType(),
                        p.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }


}