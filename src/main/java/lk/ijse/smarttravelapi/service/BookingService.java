package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.entity.Booking;
import java.util.List;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    boolean updateStatus(Long id, String status);
    boolean deleteBooking(Long id);
}
