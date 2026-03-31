package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO dto);
    List<HotelDTO> getAllHotels();
    void deleteHotel(Long id);
    List<HotelDTO> getHotelsByDestination(String destination);

}
