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
//    // 4. DELETE HOTEL
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
//        try {
//            hotelService.deleteHotel(id);
//            return new ResponseEntity<>("Hotel Deleted Successfully!", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // 5. SEARCH BY DESTINATION
//    @GetMapping("/search/{destination}")
//    public ResponseEntity<List<HotelDTO>> getHotelsByDestination(@PathVariable String destination) {
//        List<HotelDTO> hotels = hotelService.getHotelsByDestination(destination);
//        return new ResponseEntity<>(hotels, HttpStatus.OK);
//    }
//}