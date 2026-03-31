package lk.ijse.smarttravelapi.repository;

import lk.ijse.smarttravelapi.entity.Mirissa;
import lk.ijse.smarttravelapi.entity.Sigiriya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MirissaRepository extends JpaRepository<Mirissa, Long> {

    List<Sigiriya> findByDestination(String destination);
}
