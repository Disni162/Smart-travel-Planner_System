package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.DesEllaDTO;
import lk.ijse.smarttravelapi.dto.HotelDTO;

import java.util.List;

public interface EllaService {
    DesEllaDTO saveHotel(DesEllaDTO dto);
    List<DesEllaDTO> getAllHotels();
    void deleteHotel(Long id);
    List<DesEllaDTO> getHotelsByDestination(String destination);
}
