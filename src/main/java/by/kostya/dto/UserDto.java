package by.kostya.dto;

import by.kostya.entity.Role;
import lombok.*;


@Value
@Builder
public class UserDto {
    String username;
    String email;
    String password;
    Role role;
}
