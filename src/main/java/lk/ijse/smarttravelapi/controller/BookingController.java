package lk.ijse.smarttravelapi.controller;

import jakarta.validation.Valid;
import lk.ijse.smarttravelapi.dto.BookingDTO;
import lk.ijse.smarttravelapi.entity.Booking;
import lk.ijse.smarttravelapi.repository.BookingRepository;
import lk.ijse.smarttravelapi.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/bookings")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    private final BookingService bookingService;


    @PostMapping("/confirm")
    public ResponseEntity<?> confirmBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        try {

            Booking booking = new Booking();
            booking.setCustomerName(bookingDTO.getCustomerName());
            booking.setCustomerEmail(bookingDTO.getCustomerEmail());
            booking.setCustomerPhone(bookingDTO.getCustomerPhone());
            booking.setDestinationName(bookingDTO.getDestinationName());
            booking.setStayType(bookingDTO.getStayType());
            booking.setDurationDays(bookingDTO.getDurationDays());
            booking.setTotalPrice(bookingDTO.getTotalPrice());

            booking.setTravelDate(bookingDTO.getTravelDate());

            // service ek haraha save kranw
            Booking savedBooking = bookingService.saveBooking(booking);


            Map<String, Object> response = new HashMap<>();
            response.put("bookingId", savedBooking.getId());
            response.put("message", "Booking successful!");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }


    @GetMapping("/dates")
    public ResponseEntity<List<String>> getBookedDates() {
        List<String> dates = bookingRepository.findAll()
                .stream()
                .filter(b -> b.getTravelDate() != null)
                .map(b -> b.getTravelDate().toString())
                .distinct()
                .toList();
        return ResponseEntity.ok(dates);
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<?> updateBookingStatus(@PathVariable Long id, @RequestBody Map<String, String> statusMap) {
        String newStatus = statusMap.get("status");
        boolean isUpdated = bookingService.updateStatus(id, newStatus);

        if (isUpdated) {
            return ResponseEntity.ok(Map.of("message", "Status updated successfully!"));
        }
        return ResponseEntity.status(404).body("Booking ID not found!");
    }


    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        boolean isDeleted = bookingService.deleteBooking(id);
        if (isDeleted) {
            return ResponseEntity.ok("Booking " + id + " cancelled successfully.");
        }
        return ResponseEntity.status(404).body("Booking not found.");
    }
    // GET ALL BOOKINGS
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> allBookings = bookingService.getAllBookings();
        return ResponseEntity.ok(allBookings);
    }

    @GetMapping("/dates/{destName}")
    public ResponseEntity<List<String>> getBookedDatesByDest(@PathVariable String destName) {
        List<String> dates = bookingRepository.findBookedDatesByDestination(destName)
                .stream()
                .map(LocalDate::toString)
                .distinct()
                .toList();
        return ResponseEntity.ok(dates);
    }

}