package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Integer year;
    private Integer wheels;
    private String color;
    @Column(name = "vehicle_type")
    private String vehicleType;
    private Long kilometers;
    private String gearbox;
    private String fuel;
    private Integer seats;
    private Integer cylinders;
    private String interior;
    private String location;
    @Column(name = "export_status")
    private String exportStatus;
    private String description;
    @OneToMany(mappedBy = "cars")
    private List<FeaturesCategory> featuresCategories;
    private String img;
    @Column(name = "is_new")
    private Boolean isNew;
    @Column(name = "mini_description")
    private String miniDescription;
    private Double price;
}
