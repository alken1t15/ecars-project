package kz.alken1t.alex.ecarsprojectforspring.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationError {
    private boolean name;
    private boolean login;
    private boolean password;
    private boolean passwordConfirm;
    private boolean confirm;
    private boolean passwordNotCorrected;
}