package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "features_category")
@Getter
@Setter
public class FeaturesCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "featuresCategory")
    private List<FeaturesName> featuresName;
    @ManyToOne
    @JoinColumn(name = "id_cars")
    private Cars cars;
}