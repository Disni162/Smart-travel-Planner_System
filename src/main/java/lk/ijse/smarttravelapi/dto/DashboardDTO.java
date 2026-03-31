package lk.ijse.smarttravelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {
    private long totalUsers;
    private long activeBookings;
    private long totalHotels;
    private long totalDestinations;
    private List<TrendingDestinationDTO> trending;
}
