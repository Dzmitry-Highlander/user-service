package by.aghanim.user_service.service.converters;

import by.aghanim.user_service.core.dto.UserDTO;
import by.aghanim.user_service.dao.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserToUserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User source) {
        return UserDTO.builder()
                .uuid(source.getUuid())
                .nickname(source.getNickname())
                .mobileNumber(source.getMobileNumber())
                .role(source.getRole())
                //TODO .status(source.getStatus())
                .build();
    }
}
