package by.kostya.service;

import by.kostya.dto.UserDto;
import by.kostya.entity.Role;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void creatUser() {
        UserService userService = UserService.getInstance();
        UserDto userDto = UserDto.builder()
                .username("Anna")
                .email("annaSerg@mail.ru")
                .password("Anna0203")
                .role(Role.ADMIN)
                .build();
        System.out.println(userService.creatUser(userDto));
    }
}