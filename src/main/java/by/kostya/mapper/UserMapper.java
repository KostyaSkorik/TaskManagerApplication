package by.kostya.mapper;

import by.kostya.dto.UserDto;
import by.kostya.entity.User;
import by.kostya.utils.BcryptUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<UserDto, User>{
    private static final UserMapper INSTANCE = new UserMapper();
    @Override
    public User mapFrom(UserDto from) {
        return User.builder()
                .username(from.getUsername())
                .email(from.getEmail())
                .passwordHash(BcryptUtils.generateHash(from.getPassword()))
                .createdAt(LocalDateTime.now())
                .isActive(true)
                .role(from.getRole())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
