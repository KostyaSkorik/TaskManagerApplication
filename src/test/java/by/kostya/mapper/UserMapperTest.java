package by.kostya.mapper;

import by.kostya.dto.UserDto;
import by.kostya.entity.Role;
import by.kostya.entity.User;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void mapFrom() {
        UserMapper userMapper = UserMapper.getInstance();
        UserDto userDto = UserDto.builder()
                .username("Anna")
                .email("annaSerg@mail.ru")
                .password("Anna0203")
                .role(Role.ADMIN)
                .build();
        User user = userMapper.mapFrom(userDto);
        System.out.println(user);
    }
}