package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.MirissaDTO;
import lk.ijse.smarttravelapi.entity.Mirissa;
import lk.ijse.smarttravelapi.entity.Mirissa;
import lk.ijse.smarttravelapi.repository.MirissaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MirissaServiceIMPL implements MirissaService {

    private final MirissaRepository mirissaRepository;

    @Override
    public MirissaDTO saveMirissaItem(MirissaDTO dto) {

        Mirissa mirissaItem = Mirissa.builder()
                .id(dto.getId())
                .name(dto.getName())
                .destination(dto.getDestination())
                .description(dto.getDescription())
                .image(dto.getImage())
                .type(dto.getType())
                .pricePerNight(dto.getPricePerNight())
                .build();

        mirissaRepository.save(mirissaItem);
        return dto;
    }

    @Override
    public List<MirissaDTO> getAllMirissaItems() {
        return mirissaRepository.findAll()
                .stream()
                .map(m -> new MirissaDTO(
                        m.getId(),
                        m.getName(),
                        m.getDestination(),
                        m.getDescription(),
                        m.getImage(),
                        m.getType(),
                        m.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMirissaItem(Long id) {
        mirissaRepository.deleteById(id);
    }

    @Override
    public List<MirissaDTO> getItemsByDestination(String destination) {
        return mirissaRepository.findByDestination(destination)
                .stream()
                .map(m -> new MirissaDTO(
                        m.getId(),
                        m.getName(),
                        m.getDestination(),
                        m.getDescription(),
                        m.getImage(),
                        m.getType(),
                        m.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }
}