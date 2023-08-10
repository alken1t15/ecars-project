package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id ;

    private String name;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
}