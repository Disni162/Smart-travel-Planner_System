package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.entity.Booking;
import lk.ijse.smarttravelapi.repository.BookingRepository;
import lk.ijse.smarttravelapi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceIMPL implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public boolean updateStatus(Long id, String status) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setStatus(status);
            bookingRepository.save(booking);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}