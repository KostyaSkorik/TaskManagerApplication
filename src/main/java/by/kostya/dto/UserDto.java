package by.kostya.dto;

import by.kostya.entity.Role;
import jakarta.validation.constraints.Email;
import lombok.*;


@Value
@Builder
public class UserDto {
    String username;
    @Email(message = "Incorrect email")
    String email;
    String password;
    Role role;
}
