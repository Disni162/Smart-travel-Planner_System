package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.AuthDTO;
import lk.ijse.smarttravelapi.dto.AuthResponseDTO;
import lk.ijse.smarttravelapi.dto.RegisterDTO;
import lk.ijse.smarttravelapi.entity.Role;
import lk.ijse.smarttravelapi.entity.User;
import lk.ijse.smarttravelapi.repository.UserRepository;
import lk.ijse.smarttravelapi.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // REGISTER USER
    public String saveUser(RegisterDTO registerDTO) {


        if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        User user = User.builder()
                .email(registerDTO.getEmail())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(Role.valueOf(registerDTO.getRole()))
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    // LOGIN USER
    public AuthResponseDTO authenticate(AuthDTO authDTO) {

        User user = userRepository.findByEmail(authDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(authDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String access_Token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponseDTO(
                access_Token,
                user.getRole().name()
        );
    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public void updateUserRole(Long id, String role) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(Role.valueOf(role));
        userRepository.save(user);
    }
}
