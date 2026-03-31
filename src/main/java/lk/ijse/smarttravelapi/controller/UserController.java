package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.APIResponse;
import lk.ijse.smarttravelapi.dto.RegisterDTO;
import lk.ijse.smarttravelapi.entity.User;
import lk.ijse.smarttravelapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    // UI table load karanna
    @GetMapping("/getAll")
    public ResponseEntity<APIResponse> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(
                new APIResponse(200, "Users fetched successfully", users)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.ok(
                new APIResponse(200, "User deleted successfully", null)
        );
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveUser(@RequestBody RegisterDTO registerDTO) {
        // userService.saveUser  eken enne string ekk nisa ek string variable ekakt gnna
        String message = userService.saveUser(registerDTO);


        return ResponseEntity.ok(
                new APIResponse(201, message, null)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateUserRole(
            @PathVariable Long id,
            @RequestParam String role
    ) {
        userService.updateUserRole(id, role);

        return ResponseEntity.ok(
                new APIResponse(200, "User updated successfully", null)
        );
    }
}
