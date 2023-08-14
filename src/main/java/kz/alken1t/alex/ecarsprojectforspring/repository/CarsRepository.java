package kz.alken1t.alex.ecarsprojectforspring.repository;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars,Long> {

    @Query("select DISTINCT c.brand from Cars c")
    List<String> findBrand();


    @Query("select DISTINCT c.model from Cars c")
    List<String> findModel();

    @Query("select DISTINCT c.vehicleType from Cars c")
    List<String> getAllVehicleTypes();

    @Query("select DISTINCT c.cylinders from Cars c")
    List<Integer> getAllCylinders();

    @Query("select DISTINCT c.color from Cars c")
    List<String> getAllColor();

    @Query("select DISTINCT c.seats from Cars c")
    List<Integer> getAllSeats();

    @Query("select DISTINCT c.fuel from Cars c")
    List<String> getAllFuelType();

    @Query("select DISTINCT c.gearbox from Cars c")
    List<String> getAllTransmission();


    List<Cars> findAllByOrderByAddDateDesc();

    List<Cars> findAllByOrderByPriceAsc();
    List<Cars> findAllByOrderByPriceDesc();
}