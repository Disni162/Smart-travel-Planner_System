package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.DashboardResponseDTO;
import lk.ijse.smarttravelapi.dto.TrendingDestinationDTO;
import lk.ijse.smarttravelapi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // service ekk kiyl spring walat introduce krl denwa
@RequiredArgsConstructor // 2. Final variables sadaha Constructor  auto-generate krnwa
public class DashboardServiceIMPL implements DashboardService {


    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final DestinationRepository destinationRepository;
    private final BookingRepository bookingRepository;

    @Override
    public DashboardResponseDTO getDashboardStats() {
        long totalUsers = userRepository.count();
        long totalDestinations = destinationRepository.count();
        long totalHotels = hotelRepository.count();

       //meka Booking heduwam complete krnna
        long activeBookings = bookingRepository.count();
//        double totalRevenue = 0.0;


        List<TrendingDestinationDTO> trending = List.of(
                new TrendingDestinationDTO("Ella", "Luxury", "Adventure", 0),
                new TrendingDestinationDTO("Galle", "Budget", "Cultural", 0)
        );

        return new DashboardResponseDTO(
                totalUsers,
                activeBookings,
                totalHotels,
                totalDestinations,
                trending
        );
    }
}