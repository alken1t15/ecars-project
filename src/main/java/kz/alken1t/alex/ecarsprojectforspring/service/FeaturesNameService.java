package kz.alken1t.alex.ecarsprojectforspring.service;

import kz.alken1t.alex.ecarsprojectforspring.repository.FeaturesNameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeaturesNameService {
    private final FeaturesNameRepository featuresNameRepository;
}
