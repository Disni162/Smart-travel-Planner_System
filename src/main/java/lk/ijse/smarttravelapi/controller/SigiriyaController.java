package lk.ijse.smarttravelapi.controller;

import jakarta.validation.Valid;
import lk.ijse.smarttravelapi.dto.SigiriyaDTO;
import lk.ijse.smarttravelapi.service.SigiriyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sigiriya")
@RequiredArgsConstructor
@CrossOrigin
public class SigiriyaController {

    private final SigiriyaService sigiriyaService;


    @PostMapping("/save")
    public SigiriyaDTO saveSigiriyaItem(@Valid @RequestBody SigiriyaDTO dto) {
        return sigiriyaService.saveSigiriyaItem(dto);
    }


    @GetMapping
    public List<SigiriyaDTO> getAllSigiriyaItems() {
        return sigiriyaService.getAllSigiriyaItems();
    }


    @DeleteMapping("/{id}")
    public void deleteSigiriyaItem(@PathVariable Long id) {

    }


    @GetMapping("/by-destination/{destination}")
    public List<SigiriyaDTO> getItemsByDestination(@PathVariable String destination) {
        return sigiriyaService.getItemsByDestination(destination);
    }
}
