package lk.ijse.smarttravelapi.controller;

import jakarta.validation.Valid;
import lk.ijse.smarttravelapi.dto.PolonnaruwaDTO;
import lk.ijse.smarttravelapi.service.PolonnaruwaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/polonnaruwa")
@RequiredArgsConstructor
@CrossOrigin
public class PolonnaruwaController {

    private final PolonnaruwaService polonnaruwaService;

    @PostMapping("/save")
    public PolonnaruwaDTO savePolonnaruwaItem(@Valid @RequestBody PolonnaruwaDTO dto) {
        return polonnaruwaService.savePolonnaruwaItem(dto);
    }

    @GetMapping
    public List<PolonnaruwaDTO> getAllPolonnaruwaItems() {
        return polonnaruwaService.getAllPolonnaruwaItems();
    }

    @DeleteMapping("/{id}")
    public void deletePolonnaruwaItem(@PathVariable Long id) {
        polonnaruwaService.deletePolonnaruwaItem(id);
    }

    @GetMapping("/by-destination/{destination}")
    public List<PolonnaruwaDTO> getItemsByDestination(@PathVariable String destination) {
        return polonnaruwaService.getItemsByDestination(destination);
    }



}