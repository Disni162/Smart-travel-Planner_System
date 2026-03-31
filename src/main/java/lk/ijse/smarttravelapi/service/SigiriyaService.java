package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.SigiriyaDTO;

import java.util.List;

public interface SigiriyaService {


    SigiriyaDTO saveSigiriyaItem(SigiriyaDTO dto);

    List<SigiriyaDTO> getAllSigiriyaItems();

    void deleteSigiriyaItem(Long id);

    List<SigiriyaDTO> getItemsByDestination(String destination);
}
