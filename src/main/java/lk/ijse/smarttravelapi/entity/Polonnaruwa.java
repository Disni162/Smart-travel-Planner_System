package lk.ijse.smarttravelapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "polonnaruwa") //
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Polonnaruwa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "mirissa_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String destination;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false, length = 500)
    private String image;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double pricePerNight;
}
