package lk.ijse.smarttravelapi.controller;

import jakarta.validation.Valid;
import lk.ijse.smarttravelapi.dto.NuwaraeliyaDTO;
import lk.ijse.smarttravelapi.service.NuwaraeliyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nuwaraeliya")
@RequiredArgsConstructor
@CrossOrigin
public class NuwaraeliyaController {

    private final NuwaraeliyaService nuwaraeliyaService;

    @PostMapping("/save")
    public NuwaraeliyaDTO saveNuwaraeliyaItem(@Valid @RequestBody NuwaraeliyaDTO dto) {
        return nuwaraeliyaService.saveNuwaraeliyaItem(dto);
    }

    @GetMapping
    public List<NuwaraeliyaDTO> getAllNuwaraeliyaItems() {
        return nuwaraeliyaService.getAllNuwaraeliyaItems();
    }

    @DeleteMapping("/{id}")
    public void deleteNuwaraeliyaItem(@PathVariable Long id) {
        nuwaraeliyaService.deleteNuwaraeliyaItem(id);
    }

    @GetMapping("/by-destination/{destination}")
    public List<NuwaraeliyaDTO> getItemsByDestination(@PathVariable String destination) {
        return nuwaraeliyaService.getItemsByDestination(destination);
    }


    @GetMapping("/by-type/{type}")
    public List<NuwaraeliyaDTO> getItemsByType(@PathVariable String type) {
        return nuwaraeliyaService.getItemsByType(type);
    }
}