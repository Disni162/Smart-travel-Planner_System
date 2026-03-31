package lk.ijse.smarttravelapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // This will NOT be stored in database
    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private Role role;
}
