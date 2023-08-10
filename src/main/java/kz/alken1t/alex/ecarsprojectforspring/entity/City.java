package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "city")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Cars> cars;
}