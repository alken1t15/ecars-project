package kz.alken1t.alex.ecarsprojectforspring.service;

import kz.alken1t.alex.ecarsprojectforspring.entity.City;
import kz.alken1t.alex.ecarsprojectforspring.entity.Country;
import kz.alken1t.alex.ecarsprojectforspring.repository.CityRepository;
import kz.alken1t.alex.ecarsprojectforspring.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CountryService countryService;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public List<String> findAllName() {
        List<City> cities = cityRepository.findAll();
        List<String> strings = new ArrayList<>();
        for (City c : cities){
            strings.add(c.getName());
        }
        return strings;
    }

    public List<String> findCities(String country) {
        return cityRepository.findCity(country);
    }

    public List<String> findByCountry(String country){
        Country countries = countryService.findByName(country);
        List<String> strings = new ArrayList<>();
        for (City c : countries.getCities()){
            strings.add(c.getName());
        }
        return strings;
    }

    public City findByName(String str) {
        return cityRepository.findByName(str);
    }
}
