package kz.alken1t.alex.ecarsprojectforspring.repository;

import kz.alken1t.alex.ecarsprojectforspring.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {

    @Query("select c.name from City c where c.country.name = ?1")
    List<String> findCity(String country);

    City findByName(String name);
}
