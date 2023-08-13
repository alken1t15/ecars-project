package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/js")
@AllArgsConstructor
public class JsController {
    private final CityService cityService;

    @PostMapping("/city")
    public List<String> findCity(@RequestBody String input) {
        String str = input.substring(1, input.length()-1);
        if (str.equals("All")){
            return cityService.findAllName();
        }
        return cityService.findByCountry(str);
    }
}