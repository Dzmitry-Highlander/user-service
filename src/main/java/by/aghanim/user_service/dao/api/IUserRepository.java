package by.aghanim.user_service.dao.api;

import by.aghanim.user_service.dao.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends ListCrudRepository<User, UUID> {
    Optional<User> findByMobileNumber(String mobileNumber);
}
