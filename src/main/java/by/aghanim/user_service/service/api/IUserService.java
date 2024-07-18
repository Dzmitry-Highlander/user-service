package by.aghanim.user_service.service.api;

import by.aghanim.user_service.core.dto.UserCreateDTO;
import by.aghanim.user_service.dao.entity.User;

public interface IUserService extends ICRUDService<User, UserCreateDTO> {
    User findByMobileNumber(String mobileNumber);

    void activate(UserCreateDTO userCreateDTO);
}
