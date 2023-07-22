package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.service.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/catalog")
public class DetailsController {
  private final CarsService carsService;


    @GetMapping()
    public String allProductPage(){
        return "catalog_page";
    }


//    @GetMapping(path = "/product/{id}")
//    private void productPage(@PathVariable Long id){
//
//    }
}
