package lk.ijse.smarttravelapi.controller;

import jakarta.validation.Valid;
import lk.ijse.smarttravelapi.dto.HotelDTO;
import lk.ijse.smarttravelapi.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
@CrossOrigin
public class HotelController {

    private final HotelService hotelService;


    @PostMapping("/save")
    public HotelDTO saveHotel(@Valid @RequestBody HotelDTO dto) {
        return hotelService.saveHotel(dto);
    }


    @GetMapping
    public List<HotelDTO> getAllHotels() {
        return hotelService.getAllHotels();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        try {
            hotelService.deleteHotel(id);
            return ResponseEntity.ok("Hotel Deleted Successfully");
        } catch (Exception e) {
            // Error eka mokkdd kiyl pennanwa
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/by-destination/{destination}")
    public List<HotelDTO> getHotelsByDestination(@PathVariable String destination) {
        return hotelService.getHotelsByDestination(destination);
    }
}
