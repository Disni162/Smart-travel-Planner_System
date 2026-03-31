package lk.ijse.smarttravelapi.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityDTO {

    private Long id;

    @NotBlank(message = "Activity name is required")
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


    private Long destinationId;


    private String destinationName;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 hour")
    @Max(value = 168, message = "Duration cannot exceed 168 hours (1 week)")
    private Integer duration;

    @NotBlank(message = "Activity type is required")
    @Pattern(
            regexp = "^(Adventure|Relax|Cultural|Wildlife|Water|Other)$",
            message = "Invalid activity type"
    )
    private String type;
}
