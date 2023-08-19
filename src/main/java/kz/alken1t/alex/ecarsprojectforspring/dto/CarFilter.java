package kz.alken1t.alex.ecarsprojectforspring.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarFilter {
    private String brand;
    private String model;
    private Integer minKm;
    private Integer maxKm;
    private Integer minYear;
    private Integer maxYear;
    private Integer minPrice;
    private Integer maxPrice;
    private String country;
    private List<String> vehicleType = new ArrayList<>();
    private List<String> city = new ArrayList<>();
    private List<String> cylinder = new ArrayList<>();
    private List<String> color = new ArrayList<>();
    private List<String> seat = new ArrayList<>();
    private List<String> fuelType = new ArrayList<>();
    private List<String> transmission = new ArrayList<>();
    private Integer page = 0;
    private String sort;
}