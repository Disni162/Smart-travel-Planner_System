package lk.ijse.smarttravelapi.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
}
