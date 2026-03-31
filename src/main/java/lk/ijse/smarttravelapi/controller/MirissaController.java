package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.MirissaDTO;
import lk.ijse.smarttravelapi.service.MirissaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mirissa")
@RequiredArgsConstructor
@CrossOrigin
public class MirissaController {

    private final MirissaService mirissaService;

    @PostMapping("/save")
    public MirissaDTO saveMirissaItem(@RequestBody MirissaDTO dto) {
        return mirissaService.saveMirissaItem(dto);
    }

    @GetMapping
    public List<MirissaDTO> getAllMirissaItems() {
        return mirissaService.getAllMirissaItems();
    }

    @DeleteMapping("/{id}")
    public void deleteMirissaItem(@PathVariable Long id) {
        mirissaService.deleteMirissaItem(id);
    }

    @GetMapping("/by-destination/{destination}")
    public List<MirissaDTO> getItemsByDestination(@PathVariable String destination) {
        return mirissaService.getItemsByDestination(destination);
    }
}