package lk.ijse.smarttravelapi.repository;

import lk.ijse.smarttravelapi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b.travelDate FROM Booking b WHERE b.destinationName = :destName")
    List<LocalDate> findBookedDatesByDestination(@Param("destName") String destName);
}