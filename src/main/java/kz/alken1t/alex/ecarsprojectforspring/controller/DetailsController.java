package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import kz.alken1t.alex.ecarsprojectforspring.service.CarsService;
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

    @GetMapping()
    public String allProductPage(Model model){
    List<Cars> cars = carsService.findAll();
    model.addAttribute("cars",cars);
        return "catalog_page";
    }

  @GetMapping("/tg")
  @ResponseBody
  public List<Cars> allProductPage(){
    List<Cars> cars = carsService.findAll();
    return cars;
  }


//    @GetMapping(path = "/product/{id}")
//    private void productPage(@PathVariable Long id){
//
//    }
}
