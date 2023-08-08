package kz.alken1t.alex.ecarsprojectforspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "blog_page")
@Getter
@Setter
public class BlogPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_file")
    private String nameFile;
}