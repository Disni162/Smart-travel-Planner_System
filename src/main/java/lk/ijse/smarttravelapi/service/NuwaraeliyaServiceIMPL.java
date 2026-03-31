package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.NuwaraeliyaDTO;
import lk.ijse.smarttravelapi.entity.Nuwaraeliya;
import lk.ijse.smarttravelapi.repository.NuwaraeliyaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NuwaraeliyaServiceIMPL implements NuwaraeliyaService {

    private final NuwaraeliyaRepository nuwaraeliyaRepository;

    @Override
    public NuwaraeliyaDTO saveNuwaraeliyaItem(NuwaraeliyaDTO dto) {

        Nuwaraeliya nuwaraItem = Nuwaraeliya.builder()
                .id(dto.getId())
                .name(dto.getName())
                .destination(dto.getDestination())
                .description(dto.getDescription())
                .image(dto.getImage())
                .type(dto.getType())
                .pricePerNight(dto.getPricePerNight())
                .build();

        nuwaraeliyaRepository.save(nuwaraItem);
        return dto;
    }

    @Override
    public List<NuwaraeliyaDTO> getAllNuwaraeliyaItems() {
        return nuwaraeliyaRepository.findAll()
                .stream()
                .map(n -> new NuwaraeliyaDTO(
                        n.getId(),
                        n.getName(),
                        n.getDestination(),
                        n.getDescription(),
                        n.getImage(),
                        n.getType(),
                        n.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNuwaraeliyaItem(Long id) {
        nuwaraeliyaRepository.deleteById(id);
    }

    @Override
    public List<NuwaraeliyaDTO> getItemsByType(String type) {
        return List.of();
    }

    @Override
    public List<NuwaraeliyaDTO> getItemsByDestination(String destination) {
        return nuwaraeliyaRepository.findByDestination(destination)
                .stream()
                .map(n -> new NuwaraeliyaDTO(
                        n.getId(),
                        n.getName(),
                        n.getDestination(),
                        n.getDescription(),
                        n.getImage(),
                        n.getType(),
                        n.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }
}