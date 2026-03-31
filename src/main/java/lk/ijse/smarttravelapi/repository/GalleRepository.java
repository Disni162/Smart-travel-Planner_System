package lk.ijse.smarttravelapi.repository;

import lk.ijse.smarttravelapi.entity.Galle;
import lk.ijse.smarttravelapi.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleRepository extends JpaRepository<Galle, Long> {
    List<Hotel> findByDestination(String destination);
}
