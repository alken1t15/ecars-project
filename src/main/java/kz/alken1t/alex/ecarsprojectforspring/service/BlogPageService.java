package kz.alken1t.alex.ecarsprojectforspring.service;

import kz.alken1t.alex.ecarsprojectforspring.entity.BlogPage;
import kz.alken1t.alex.ecarsprojectforspring.repository.BlogPageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogPageService {
    private final BlogPageRepository blogPageRepository;

    public String findById(Long id) {
        BlogPage blogPage = blogPageRepository.findById(id).orElseThrow();
        return blogPage.getNameFile();
    }
}