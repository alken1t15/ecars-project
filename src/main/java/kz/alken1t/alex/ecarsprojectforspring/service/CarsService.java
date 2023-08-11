package kz.alken1t.alex.ecarsprojectforspring.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
    private final EntityManager entityManager;

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

    public List<Cars> findBySort(String brand, String modelCar, List<String> vehicleTypesCar, Integer minKm, Integer maxKm, Integer maxYear, Integer minYear, Integer minPrice, Integer maxPrice, String countryId, List<String> citiesCar, List<String> cylindersCar, List<String> colorsCar, List<String> seatsCar, List<String> fuelTypesCar, List<String> transmissionsCar) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cars> critQuery = builder.createQuery(Cars.class);
        Root<Cars> root = critQuery.from(Cars.class);

        List<Predicate> predicates = new ArrayList<>();
        if (brand!=null && !brand.isEmpty()){
            predicates.add(builder.equal(root.get("brand"),brand));
        }
        if (modelCar!=null &&!modelCar.isEmpty() && !modelCar.equals("All")){
            predicates.add(builder.equal(root.get("model"),modelCar));
        }
        if (vehicleTypesCar!=null && !vehicleTypesCar.isEmpty()){
            for (String vehicleType : vehicleTypesCar){
                predicates.add(builder.equal(root.get("vehicleType"),vehicleType));
            }
        }

        if (minKm != null && maxKm!=null){
            predicates.add(builder.between(root.get("kilometers"),minKm,maxKm));
        }
        else if (minKm !=null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("kilometers"),minKm));
        }
        else if (maxKm != null){
            predicates.add(builder.between(root.get("kilometers"),0,maxKm));
        }

        if (minYear != null && maxYear!=null){
            predicates.add(builder.between(root.get("year"),minYear,maxYear));
        }
        else if (minYear !=null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("year"),minYear));
        }
        else if (maxYear != null){
            predicates.add(builder.between(root.get("year"),0,maxYear));
        }

        if (minPrice != null && maxPrice!=null){
            predicates.add(builder.between(root.get("price"),minPrice,maxPrice));
        }
        else if (minYear !=null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("price"),minPrice));
        }
        else if (maxYear != null){
            predicates.add(builder.between(root.get("price"),0,maxPrice));
        }

        if (cylindersCar!=null && !cylindersCar.isEmpty()){
            for (String cylinder : cylindersCar){
                predicates.add(builder.equal(root.get("cylinders"),cylinder));
            }
        }
        if (colorsCar!=null && !colorsCar.isEmpty()){
            for (String color : colorsCar){
                predicates.add(builder.equal(root.get("color"),color));
            }
        }
        if (seatsCar!=null && !seatsCar.isEmpty()){
            for (String seat : seatsCar){
                predicates.add(builder.equal(root.get("seats"),seat));
            }
        }
        if (fuelTypesCar!=null && !fuelTypesCar.isEmpty()){
            for (String fuelType : fuelTypesCar){
                predicates.add(builder.equal(root.get("fuel"),fuelType));
            }
        }
        if (transmissionsCar!=null && !transmissionsCar.isEmpty()){
            for (String transmission : transmissionsCar){
                predicates.add(builder.equal(root.get("gearbox"),transmission));
            }
        }
        if (predicates.isEmpty()){
            return findAll();
        }
        Predicate finalPredicate = builder.and(predicates.toArray(new Predicate[predicates.size()]));
        critQuery.where(finalPredicate);
        TypedQuery<Cars> query = entityManager.createQuery(critQuery);
        return query.getResultList();
    }
}