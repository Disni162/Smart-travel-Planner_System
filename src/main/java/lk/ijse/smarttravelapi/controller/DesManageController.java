package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.APIResponse;
import lk.ijse.smarttravelapi.dto.DestinationDTO;
//import lk.ijse.smarttravelapi.util.APIResponse;
import lk.ijse.smarttravelapi.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destination")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DesManageController {

    private final DestinationService destinationService;


    @PostMapping
    public ResponseEntity<APIResponse> saveDestination(@RequestBody DestinationDTO destinationDTO) {
        try {
            DestinationDTO savedDest = destinationService.saveDestination(destinationDTO);
            return ResponseEntity.ok(
                    new APIResponse(201, "Destination saved successfully", savedDest)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    new APIResponse(500, e.getMessage(), null)
            );
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<APIResponse> getAllDestinations() {
        try {
            List<DestinationDTO> allDestinations = destinationService.getAllDestinations();
            return ResponseEntity.ok(
                    new APIResponse(200, "Success", allDestinations)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    new APIResponse(500, "Internal Server Error", null)
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteDestination(@PathVariable Long id) {
        try {
            destinationService.deleteDestination(id);
            return ResponseEntity.ok(
                    new APIResponse(200, "Destination deleted successfully", null)
            );
        } catch (Exception e) {
            return ResponseEntity.status(404).body(
                    new APIResponse(404, "Destination not found", null)
            );
        }
    }
}