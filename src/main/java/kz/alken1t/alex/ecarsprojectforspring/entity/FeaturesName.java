package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "features_name")
public class FeaturesName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_features_category")
    private FeaturesCategory featuresCategory;
}
