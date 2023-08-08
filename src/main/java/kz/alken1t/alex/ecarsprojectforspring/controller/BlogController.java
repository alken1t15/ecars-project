package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.service.BlogPageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
@AllArgsConstructor
public class BlogController {

    private final BlogPageService blogPageService;

    @GetMapping()
    public String mainPage(){
        return "blog_page";
    }

    @GetMapping("/{id}")
    public String getBlogPage(@PathVariable Long id){
        return blogPageService.findById(id);
    }
}
