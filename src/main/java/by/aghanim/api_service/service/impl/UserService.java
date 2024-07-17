package by.aghanim.api_service.service.impl;

import by.aghanim.api_service.core.dto.UserCreateDTO;
import by.aghanim.api_service.dao.api.IUserRepository;
import by.aghanim.api_service.dao.entity.User;
import by.aghanim.api_service.service.api.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;

    @Override
    public User findByMobileNumber(String mobileNumber) {
        return null;
    }

    @Override
    public void activate(UserCreateDTO userCreateDTO) {

    }

    @Transactional
    @Override
    public User create(UserCreateDTO item) {
        userRepository.findByMobileNumber(item.getMobileNumber())
                .ifPresent(e -> {
            //TODO throw new MobileNumberIsAlreadyTakenException("USER_EXISTS_ERROR);
        });

        item.setPassword(passwordEncoder.encode(item.getPassword()));

        return userRepository.save(Objects.requireNonNull(conversionService.convert(item, User.class))); //TODO converter for User
    }

    @Override
    public List<User> read() {
        return List.of();
    }

    @Override
    public User read(UUID id) {
        return null;
    }
}
