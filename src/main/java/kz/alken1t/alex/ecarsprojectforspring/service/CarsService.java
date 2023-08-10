package kz.alken1t.alex.ecarsprojectforspring.service;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import kz.alken1t.alex.ecarsprojectforspring.repository.CarsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarsService {
    private final CarsRepository carsRepository;

    public List<Cars> findAll() {
        return carsRepository.findAll();
    }

    public Cars findById(Long id) {
        return carsRepository.findById(id).orElse(null);
    }

    public List<Cars> getFoursCar() {
        Pageable pageable = PageRequest.of(0, 4);
        return carsRepository.findAll(pageable).getContent();
    }

    public List<String> getAllBrand() {
        return carsRepository.findBrand();
    }

    public List<String> getAllModels() {
        return carsRepository.findModel();
    }

    public List<String> getAllVehicleTypes() {
        return carsRepository.getAllVehicleTypes();
    }

    public List<Integer> getAllCylinders() {
        return carsRepository.getAllCylinders();
    }

    public List<String> getAllColor() {
        return carsRepository.getAllColor();
    }

    public List<Integer> getAllSeats() {
        return carsRepository.getAllSeats();
    }

    public List<String> getAllFuelType() {
        return carsRepository.getAllFuelType();
    }

    public List<String> getAllTransmission() {
        return carsRepository.getAllTransmission();
    }
}