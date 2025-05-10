package by.kostya.dao;

import by.kostya.entity.Role;
import by.kostya.entity.User;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void save() {
        User user = User.builder()
                .username("kostya")
                .email("kostya@mail.ru")
                .passwordHash("52HashSaver")
                .createdAt(LocalDateTime.now())
                .isActive(true)
                .role(Role.ADMIN)
                .build();
        UserDao userDao = UserDao.getInstance();
        var result = userDao.save(user);
    }
}