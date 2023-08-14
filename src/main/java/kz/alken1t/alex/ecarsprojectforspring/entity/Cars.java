package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;
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
    @Column(name = "img_big")
    private String imgBig;
    @OneToMany(mappedBy = "cars")
    private List<ImgCars> imgCars;
    @Column(name = "price_old")
    private Double priceOld;
    @Column(name = "add_date")
    private LocalDateTime addDate;
}
