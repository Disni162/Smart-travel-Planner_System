package lk.ijse.smarttravelapi.controller;

import jakarta.validation.Valid;
import lk.ijse.smarttravelapi.dto.APIResponse;
import lk.ijse.smarttravelapi.dto.DestinationDTO;
import lk.ijse.smarttravelapi.entity.Destination;
import lk.ijse.smarttravelapi.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/destinations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DestinationController {

    private final DestinationRepository destinationRepository;


    @GetMapping
    public ResponseEntity<APIResponse> getAllDestinations() {
        List<DestinationDTO> destinations = destinationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new APIResponse(
                200,
                "Destinations retrieved successfully",
                destinations
        ));
    }


    @PostMapping("/save")
    public ResponseEntity<APIResponse> addDestination(@Valid @RequestBody DestinationDTO destinationDTO) {
        Destination destination = new Destination();
        destination.setName(destinationDTO.getName());
        destination.setDescription(destinationDTO.getDescription());
        destination.setImage(destinationDTO.getImage());

        Destination saved = destinationRepository.save(destination);

        return ResponseEntity.status(201).body(new APIResponse(
                201,
                "Destination added successfully",
                convertToDTO(saved)
        ));
    }


    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateDestination(
            @PathVariable Long id,
            @RequestBody DestinationDTO destinationDTO
    ) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        if (!optionalDestination.isPresent()) {
            return ResponseEntity.status(404).body(new APIResponse(
                    404,
                    "Destination not found",
                    null
            ));
        }

        Destination destination = optionalDestination.get();
        destination.setName(destinationDTO.getName());
        destination.setDescription(destinationDTO.getDescription());
        destination.setImage(destinationDTO.getImage());

        Destination updated = destinationRepository.save(destination);

        return ResponseEntity.ok(new APIResponse(
                200,
                "Destination updated successfully",
                convertToDTO(updated)
        ));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteDestination(@PathVariable Long id) {
        if (!destinationRepository.existsById(id)) {
            return ResponseEntity.status(404).body(new APIResponse(
                    404,
                    "Destination not found",
                    null
            ));
        }
        destinationRepository.deleteById(id);
        return ResponseEntity.ok(new APIResponse(
                200,
                "Destination deleted successfully",
                null
        ));
    }

    //  convert entity to DTO
    private DestinationDTO convertToDTO(Destination destination) {
        return DestinationDTO.builder()
                .id(destination.getId())
                .name(destination.getName())
                .description(destination.getDescription())
                .image(destination.getImage())
                .build();
    }
}
