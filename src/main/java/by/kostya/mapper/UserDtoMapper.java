package by.kostya.mapper;

import by.kostya.dto.UserDto;
import by.kostya.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDtoMapper implements Mapper<User, UserDto>{
    private static final UserDtoMapper INSTANCE = new UserDtoMapper();

    public static UserDtoMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public UserDto mapFrom(User from) {
        return UserDto.builder()
                .username(from.getUsername())
                .email(from.getEmail())
                .role(from.getRole())
                .build();
    }
}
