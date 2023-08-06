package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "img_cars")
@Getter
@Setter
public class ImgCars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cars")
    private Cars cars;

    private String img;
}