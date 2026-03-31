package lk.ijse.smarttravelapi.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private Long id;
    @NotBlank(message = "Hotel name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3-100 characters")
    private String name;

    private String destination;
    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10-500 characters")
    private String description;

    @NotBlank(message = "Image URL is required")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "Image must be a valid URL"
    )
    private String image;
    private String type;
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private double pricePerNight;

    public HotelDTO(String s, String name, String destination, String description, String image, String type, double pricePerNight) {
    }
}
