package by.aghanim.user_service.service.converters;

import by.aghanim.user_service.core.dto.UserCreateDTO;
import by.aghanim.user_service.dao.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserCreateDTOToUserConverter implements Converter<UserCreateDTO, User> {
    @Override
    public User convert(UserCreateDTO source) {
        return User.builder()
                .nickname(source.getNickname())
                .mobileNumber(source.getMobileNumber())
                .password(source.getPassword())
                .role(source.getRole())
                //TODO .status(source.getStatus())
                .build();
    }
}
