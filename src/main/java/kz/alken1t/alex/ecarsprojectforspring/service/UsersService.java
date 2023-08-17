package kz.alken1t.alex.ecarsprojectforspring.service;

import kz.alken1t.alex.ecarsprojectforspring.entity.Users;
import kz.alken1t.alex.ecarsprojectforspring.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public void save(Users users) {
        usersRepository.save(users);
    }

    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email).orElseThrow();
    }
}