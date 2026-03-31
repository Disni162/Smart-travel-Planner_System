package lk.ijse.smarttravelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {
    private String access_Token;
    private String role;
}
