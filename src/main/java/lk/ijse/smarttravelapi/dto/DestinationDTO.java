package lk.ijse.smarttravelapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationDTO {

    private Long id;
    @NotBlank(message = "Destination name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3-100 characters")
    private String name;
    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10-500 characters")
    private String description;
    @NotBlank(message = "Image URL is required")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "Image must be a valid URL"
    )
    private String image;


    public void setHotels(List<HotelDTO> hotelDTOs) {
    }
}
