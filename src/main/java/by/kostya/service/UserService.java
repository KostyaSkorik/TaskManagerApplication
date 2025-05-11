package by.kostya.service;


import by.kostya.dao.UserDao;
import by.kostya.dto.UserDto;
import by.kostya.entity.User;
import by.kostya.mapper.UserMapper;
import jakarta.validation.ConstraintViolationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final UserDao userDao = UserDao.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public Long creatUser(UserDto userDto) throws ConstraintViolationException {
        /*TO-DO Validation
        Думаю можно отлавливать exceptions от hibernate валидатора
         */

        //TODO validation
        User user = userMapper.mapFrom(userDto);
        var result = userDao.save(user);
        return result.getId();

    }

}
