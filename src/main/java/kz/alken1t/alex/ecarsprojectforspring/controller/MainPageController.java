package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import kz.alken1t.alex.ecarsprojectforspring.service.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainPageController {
    private final CarsService carsService;

    @GetMapping({"/", "/main"})
    public String mainPage(Model model) {
        List<Cars> cars = carsService.getFoursCar();
        model.addAttribute("cars", cars);
        return "main_page";
    }
}