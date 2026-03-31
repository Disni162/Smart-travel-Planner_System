package lk.ijse.smarttravelapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private Long id;
    private String customerName;
    @NotBlank(message = "Email is required")
    private String customerEmail;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String customerPhone;
    private String destinationName;
    private String stayType;
    private int durationDays;
    private double totalPrice;


    private LocalDate travelDate;


    private LocalDateTime bookingDate;
    private String status;
}