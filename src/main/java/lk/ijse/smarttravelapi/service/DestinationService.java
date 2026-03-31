package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.DestinationDTO;

import java.util.List;

public interface DestinationService {




    DestinationDTO saveDestination(DestinationDTO dto);


    DestinationDTO getDestinationById(Long id);


    void deleteDestination(Long id);

    List<DestinationDTO> getAllDestinations();
}
