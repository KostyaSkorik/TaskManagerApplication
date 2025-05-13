package by.kostya.service;


import by.kostya.dao.UserDao;
import by.kostya.dto.UserDto;
import by.kostya.entity.User;
import by.kostya.mapper.UserDtoMapper;
import by.kostya.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final UserDtoMapper userDtoMapper = UserDtoMapper.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public Long creatUser(UserDto userDto) {
        User user = userMapper.mapFrom(userDto);
        var result = userDao.save(user);
        return result.getId();
    }
    public Optional<UserDto> login(String username, String password){
        return userDao.findByUsernameAndPassword(username,password).map(userDtoMapper::mapFrom);
    }

}
