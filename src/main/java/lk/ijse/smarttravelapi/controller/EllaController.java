package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.DesEllaDTO;
import lk.ijse.smarttravelapi.service.EllaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ella")
@RequiredArgsConstructor
@CrossOrigin
public class EllaController {

    private final EllaService ellaService;


    @PostMapping("/save")
    public DesEllaDTO saveHotel(@RequestBody DesEllaDTO dto) {
        return ellaService.saveHotel(dto);
    }


    @GetMapping
    public List<DesEllaDTO> getAllHotels() {
        return ellaService.getAllHotels();
    }


    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        ellaService.deleteHotel(id);
    }


    @GetMapping("/by-destination/{destination}")
    public List<DesEllaDTO> getHotelsByDestination(@PathVariable String destination) {
        return ellaService.getHotelsByDestination(destination);
    }
}
