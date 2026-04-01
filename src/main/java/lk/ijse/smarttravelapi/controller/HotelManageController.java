package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.HotelDTO;
import lk.ijse.smarttravelapi.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@CrossOrigin(origins = "*") //
public class HotelManageController {

    @Autowired
    private HotelService hotelService;


    @PutMapping("/update")
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
        if (hotelDTO.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HotelDTO updatedHotel = hotelService.saveHotel(hotelDTO);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<HotelDTO> all = hotelService.getAllHotels();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}