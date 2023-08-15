package kz.alken1t.alex.ecarsprojectforspring.controller;

import kz.alken1t.alex.ecarsprojectforspring.dto.RegistrationError;
import kz.alken1t.alex.ecarsprojectforspring.entity.Users;
import kz.alken1t.alex.ecarsprojectforspring.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class SecurityController {
    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/profile")
    public String profilePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Users users = usersService.findByEmail(username);
        model.addAttribute("users",users);
        return "profile_page";
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login_page";
    }

    @GetMapping("/forgot")
    private String forgotPage(Model model){
        model.addAttribute("email",false);
        return "forgot_page";
    }

    @PostMapping("/forgot_email")
    private String forgotEmailPage(@RequestParam("email") String email,Model model){
        if (email.isEmpty()){
            model.addAttribute("email",true);
            return "forgot_page";
        }
        model.addAttribute("email",email);
        return "forgot_page_second";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("registrationError", new RegistrationError());
        return "sign_up_page";
    }

    @PostMapping("/registration")
    public String registrationAccount(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "login") String login,
                                      @RequestParam(name = "password") String password,
                                      @RequestParam(name = "password_confirm") String passwordConfirm,
                                      @RequestParam(name = "confirm", required = false) String confirm, Model model) {
        RegistrationError registrationError = new RegistrationError(false, false, false, false, false, false);
        if (name.isEmpty()) {
            registrationError.setName(true);
        }
        if (login.isEmpty()) {
            registrationError.setLogin(true);
        }
        if (password.isEmpty()) {
            registrationError.setPassword(true);
        }
        if (passwordConfirm.isEmpty()) {
            registrationError.setPasswordConfirm(true);
        }
        if (!password.equals(passwordConfirm)) {
            registrationError.setPasswordNotCorrected(true);
        }
        if (confirm == null) {
            registrationError.setConfirm(true);
        }
        if (registrationError.isName() || registrationError.isLogin() || registrationError.isConfirm() || registrationError.isPasswordConfirm() || registrationError.isPassword() || registrationError.isPasswordNotCorrected()) {
            model.addAttribute("registrationError", registrationError);
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
}