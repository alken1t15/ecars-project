package kz.alken1t.alex.ecarsprojectforspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutUsController {
    @GetMapping
    public String page() {
        return "about_us_page";
    }
}