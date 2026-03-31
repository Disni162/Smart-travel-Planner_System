package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.NuwaraeliyaDTO;
import java.util.List;

public interface NuwaraeliyaService {


    NuwaraeliyaDTO saveNuwaraeliyaItem(NuwaraeliyaDTO dto);

    List<NuwaraeliyaDTO> getAllNuwaraeliyaItems();

    void deleteNuwaraeliyaItem(Long id);

    List<NuwaraeliyaDTO> getItemsByType(String type);

    List<NuwaraeliyaDTO> getItemsByDestination(String destination);
}