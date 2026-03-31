package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.DestinationGalleDTO;
import java.util.List;

public interface GalleService {

    DestinationGalleDTO saveGalleItem(DestinationGalleDTO dto);


    List<DestinationGalleDTO> getAllGalleItems();


    void deleteGalleItem(Long id);


    List<DestinationGalleDTO> getItemsByDestination(String destination);
}