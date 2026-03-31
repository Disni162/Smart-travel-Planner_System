package lk.ijse.smarttravelapi.repository;

import lk.ijse.smarttravelapi.entity.Galle;
import lk.ijse.smarttravelapi.entity.Hotel;
import lk.ijse.smarttravelapi.entity.Nuwaraeliya;
import lk.ijse.smarttravelapi.entity.Sigiriya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NuwaraeliyaRepository extends JpaRepository<Nuwaraeliya, Long> {
    List<Hotel> findByDestination(String destination);
}
