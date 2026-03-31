package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.MirissaDTO;
import java.util.List;

public interface MirissaService {


    MirissaDTO saveMirissaItem(MirissaDTO dto);

    List<MirissaDTO> getAllMirissaItems();


    void deleteMirissaItem(Long id);


    List<MirissaDTO> getItemsByDestination(String destination);
}