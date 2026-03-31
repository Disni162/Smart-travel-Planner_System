package lk.ijse.smarttravelapi.repository;

import lk.ijse.smarttravelapi.entity.DesElla;
import lk.ijse.smarttravelapi.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EllaRepository extends JpaRepository<DesElla, Long> {
    List<Hotel> findByDestination(String destination);
}
