package lk.ijse.smarttravelapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels-ella")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DesElla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String destination;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private double pricePerNight;

}
