package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.DestinationGalleDTO;
import lk.ijse.smarttravelapi.service.GalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/galle")
@RequiredArgsConstructor
@CrossOrigin
public class DestinationGalleController {

    private final GalleService galleService;

    @PostMapping("/save")
    public DestinationGalleDTO saveGalleItem(@RequestBody DestinationGalleDTO dto) {
        return galleService.saveGalleItem(dto);
    }

    @GetMapping
    public List<DestinationGalleDTO> getAllGalleItems() {
        return galleService.getAllGalleItems();
    }

    @DeleteMapping("/{id}")
    public void deleteGalleItem(@PathVariable Long id) {
        galleService.deleteGalleItem(id);
    }

    @GetMapping("/by-destination/{destination}")
    public List<DestinationGalleDTO> getItemsByDestination(@PathVariable String destination) {
        return galleService.getItemsByDestination(destination);
    }
}