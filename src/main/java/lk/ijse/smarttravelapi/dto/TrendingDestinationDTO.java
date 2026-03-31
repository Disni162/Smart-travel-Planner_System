package lk.ijse.smarttravelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrendingDestinationDTO {
    private String location;
    private String type;
    private String mode;
    private int bookings;
}
