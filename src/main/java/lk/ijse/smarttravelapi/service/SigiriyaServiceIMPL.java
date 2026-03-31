package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.SigiriyaDTO;
import lk.ijse.smarttravelapi.entity.Sigiriya;
import lk.ijse.smarttravelapi.repository.SigiriyaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SigiriyaServiceIMPL implements SigiriyaService {

    private final SigiriyaRepository sigiriyaRepository;


    @Override
    public SigiriyaDTO saveSigiriyaItem(SigiriyaDTO dto) {

        Sigiriya entity = new Sigiriya(
                dto.getId(),
                dto.getName(),
                dto.getDestination(),
                dto.getDescription(),
                dto.getImage(),
                dto.getType(),
                dto.getPricePerNight()
        );

        sigiriyaRepository.save(entity);
        return dto;
    }


    @Override
    public List<SigiriyaDTO> getAllSigiriyaItems() {
        return sigiriyaRepository.findAll()
                .stream()
                .map(s -> new SigiriyaDTO(
                        s.getId(),
                        s.getName(),
                        s.getDestination(),
                        s.getDescription(),
                        s.getImage(),
                        s.getType(),
                        s.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteSigiriyaItem(Long id) {
        sigiriyaRepository.deleteById(id);
    }


    @Override
    public List<SigiriyaDTO> getItemsByDestination(String destination) {
        return sigiriyaRepository.findByDestination(destination)
                .stream()
                .map(s -> new SigiriyaDTO(
                        s.getId(),
                        s.getName(),
                        s.getDestination(),
                        s.getDescription(),
                        s.getImage(),
                        s.getType(),
                        s.getPricePerNight()
                ))
                .collect(Collectors.toList());
    }
}
