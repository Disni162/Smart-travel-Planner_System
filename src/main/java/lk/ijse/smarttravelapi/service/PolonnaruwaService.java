package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.PolonnaruwaDTO;

import java.util.List;

public interface PolonnaruwaService {
    PolonnaruwaDTO savePolonnaruwaItem(PolonnaruwaDTO dto);


    List<PolonnaruwaDTO> getAllPolonnaruwaItems();

    void deletePolonnaruwaItem(Long id);

    List<PolonnaruwaDTO> getItemsByDestination(String destination);


}

