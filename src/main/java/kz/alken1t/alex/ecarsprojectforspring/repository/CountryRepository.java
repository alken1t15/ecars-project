package kz.alken1t.alex.ecarsprojectforspring.repository;

import kz.alken1t.alex.ecarsprojectforspring.entity.City;
import kz.alken1t.alex.ecarsprojectforspring.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
