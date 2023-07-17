package kz.alken1t.alex.ecarsprojectforspring.repository;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars,Long> {

}