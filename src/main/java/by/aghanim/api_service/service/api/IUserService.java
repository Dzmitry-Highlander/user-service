package by.aghanim.api_service.service.api;

import by.aghanim.api_service.core.dto.UserCreateDTO;
import by.aghanim.api_service.dao.entity.User;

public interface IUserService extends ICRUDService<User, UserCreateDTO> {
}
