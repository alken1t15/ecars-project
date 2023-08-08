package kz.alken1t.alex.ecarsprojectforspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationError {
    private boolean name;
    private boolean login;
    private boolean password;
    private boolean passwordConfirm;
    private boolean confirm;
}