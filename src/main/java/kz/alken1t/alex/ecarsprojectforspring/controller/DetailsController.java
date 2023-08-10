package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import kz.alken1t.alex.ecarsprojectforspring.entity.City;
import kz.alken1t.alex.ecarsprojectforspring.entity.Country;
import kz.alken1t.alex.ecarsprojectforspring.service.CarsService;
import kz.alken1t.alex.ecarsprojectforspring.service.CityService;
import kz.alken1t.alex.ecarsprojectforspring.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/catalog")
public class DetailsController {
    private final CarsService carsService;
    private final CountryService countryService;
    private final CityService cityService;

    @GetMapping()
    public String allProductPage(Model model) {
        List<Cars> cars = carsService.findAll();
        List<String> brands = carsService.getAllBrand();
        List<String> models = carsService.getAllModels();
        List<String> vehicleTypes = carsService.getAllVehicleTypes();
        List<Country> countries = countryService.findAll();
        List<City> cities = cityService.findAll();
        List<Integer> cylinders =carsService.getAllCylinders();
        List<String> colors =carsService.getAllColor();
        List<Integer> seats =carsService.getAllSeats();
        List<String> fuelTypes =carsService.getAllFuelType();
        List<String> transmissions =carsService.getAllTransmission();
        model.addAttribute("cars", cars);
        model.addAttribute("brands", brands);
        model.addAttribute("modelsCar", models);
        model.addAttribute("vehicleTypes", vehicleTypes);
        model.addAttribute("countries",countries);
        model.addAttribute("cities",cities);
        model.addAttribute("cylinders",cylinders);
        model.addAttribute("colors",colors);
        model.addAttribute("seats",seats);
        model.addAttribute("fuelTypes",fuelTypes);
        model.addAttribute("transmissions",transmissions);
        return "catalog_page";
    }

    @GetMapping("/{id}")
    public String getOneCarPage(@PathVariable Long id, Model model) {
        System.out.println("ffsdfsdfsdf");
        System.out.println(id);
        Cars car = carsService.findById(id);
        List<Cars> cars = carsService.getFoursCar();
        model.addAttribute("car", car);
        model.addAttribute("cars", cars);
        return "details_page";
    }

    @GetMapping("/tg")
    @ResponseBody
    public List<Cars> allProductPage() {
        List<Cars> cars = carsService.findAll();
        return cars;
    }


//    @GetMapping(path = "/product/{id}")
//    private void productPage(@PathVariable Long id){
//
//    }
}
