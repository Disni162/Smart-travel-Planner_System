package lk.ijse.smarttravelapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sigiriya")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sigiriya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String destination;

    @Column(length = 1000)
    private String description;

    private String image;


    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double pricePerNight;
}
