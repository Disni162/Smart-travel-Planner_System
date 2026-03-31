package lk.ijse.smarttravelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationGalleDTO {
    private Long id;
    private String name;
    private String destination;
    private String description;
    private String image;
    private String type;
    private double pricePerNight;
}
