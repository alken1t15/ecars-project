package kz.alken1t.alex.ecarsprojectforspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frequently")
public class FrequentlyController {
    @GetMapping
    public String page() {
        return "faq_page";
    }
}