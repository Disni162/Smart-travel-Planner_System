package lk.ijse.smarttravelapi.repository;

import lk.ijse.smarttravelapi.entity.Galle;
import lk.ijse.smarttravelapi.entity.Hotel;
import lk.ijse.smarttravelapi.entity.Polonnaruwa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolonnaruwaRepository extends JpaRepository<Polonnaruwa, Long> {
    List<Hotel> findByDestination(String destination);
}
