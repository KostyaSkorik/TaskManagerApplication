package by.kostya.dao;

import by.kostya.entity.Role;
import by.kostya.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


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
    @Test
    void findByUsernameAndPasswordTest(){
        String username = "devKodstya5";
        String password = "12345";

        UserDao userDao = UserDao.getInstance();
        System.out.println(userDao.findByUsernameAndPassword(username,password));

    }
}