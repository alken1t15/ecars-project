package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.dto.RegistrationError;
import kz.alken1t.alex.ecarsprojectforspring.entity.Users;
import kz.alken1t.alex.ecarsprojectforspring.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class SecurityController {
    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {

        return "login_page";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {

        return "sign_up_page";
    }

    @PostMapping("/registration")
    public String registrationAccount(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "login") String login,
                                      @RequestParam(name = "password") String password,
                                      @RequestParam(name = "password_confirm") String passwordConfirm,
                                      @RequestParam(name = "confirm") Boolean confirm) {
        RegistrationError registrationError = new RegistrationError(false, false, false, false, false);
        if (name.isEmpty()) {
            registrationError.setName(true);
        }
        if (login.isEmpty()) {
            registrationError.setLogin(true);
        }
//        if (!password.equals(passwordConfirm) || password.isEmpty() || passwordConfirm.isEmpty()){
//            registrationError.set
//        }
        if (confirm == false) {
            registrationError.setConfirm(true);
        }
        if (registrationError.isName() == true || registrationError.isLogin() == true || registrationError.isConfirm() == true) {
            return "sign_up_page";
        } else {
            Users users = new Users();
            users.setFirstName(name);
            users.setEmail(login);
            users.setPassword(passwordEncoder.encode(password));
            usersService.save(users);
            return "redirect:/login";

        }
    }

    @GetMapping("/registration_error")
    public String registrationError(Model model) {

        return "sign_up_page";
    }
}