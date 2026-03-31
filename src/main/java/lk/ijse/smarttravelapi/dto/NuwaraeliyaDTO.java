package lk.ijse.smarttravelapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuwaraeliyaDTO {
    private Long id;

    @NotBlank(message = " name is required")
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
    private double pricePerNight;
}
