package kz.alken1t.alex.ecarsprojectforspring.service;

import kz.alken1t.alex.ecarsprojectforspring.repository.CarsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarsService {
    private final CarsRepository carsRepository;

}
