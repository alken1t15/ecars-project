package kz.alken1t.alex.ecarsprojectforspring.dto;

import lombok.Data;

@Data
public class RegistrationAccount {
    private String name;
    private String login;
    private String password;
    private String passwordConfirm;
    private String confirm;
}