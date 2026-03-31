package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.APIResponse;
import lk.ijse.smarttravelapi.dto.AuthDTO;
import lk.ijse.smarttravelapi.dto.RegisterDTO;
import lk.ijse.smarttravelapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/travel")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    private final UserService userService;
    @PostMapping("signup")
    public ResponseEntity<APIResponse> saveUser(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(new APIResponse(
                200,"user registered successfully",userService.saveUser(registerDTO)
        ));
    }
    @PostMapping("signin")
    public ResponseEntity<APIResponse>loginUser(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(new APIResponse(
                200,"user logged in successfully",userService.authenticate(authDTO)
        ));
    }
}
