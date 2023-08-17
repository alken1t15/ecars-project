package kz.alken1t.alex.ecarsprojectforspring.repository;

import kz.alken1t.alex.ecarsprojectforspring.entity.FeaturesName;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeaturesNameRepository extends JpaRepository<FeaturesName, Long> {
}