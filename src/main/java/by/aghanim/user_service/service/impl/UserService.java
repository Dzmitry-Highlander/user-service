package by.aghanim.user_service.service.impl;

import by.aghanim.user_service.core.dto.UserCreateDTO;
import by.aghanim.user_service.dao.api.IUserRepository;
import by.aghanim.user_service.dao.entity.User;
import by.aghanim.user_service.service.api.IUserService;
import by.aghanim.user_service.service.exceptions.ItemNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private static final String USER_EXISTS_ERROR = "A user with this mobile number is already registered!";
    private static final String USER_NOT_FOUND_ERROR = "A user with this mobile number was not found!";

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;

    @Transactional(readOnly = true)
    @Override
    public User findByMobileNumber(String mobileNumber) {
        return userRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ItemNotFoundException(USER_NOT_FOUND_ERROR));
    }

    @Transactional
    @Override
    public void activate(@Valid UserCreateDTO userCreateDTO) {
        User user = userRepository.findByMobileNumber(userCreateDTO.getMobileNumber())
                .orElseThrow(() -> new ItemNotFoundException(USER_NOT_FOUND_ERROR));

        //TODO user.setStatus(EUserStatus.ACTIVATED); add enum EUserStatus and refactor User entity

        userRepository.save(user);
    }

    @Transactional
    @Override
    public User create(UserCreateDTO item) {
        userRepository.findByMobileNumber(item.getMobileNumber())
                .ifPresent(e -> {
            //TODO throw new MobileNumberIsAlreadyTakenException(USER_EXISTS_ERROR);
        });

        item.setPassword(passwordEncoder.encode(item.getPassword()));

        return userRepository.save(Objects.requireNonNull(conversionService.convert(item, User.class)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> read() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User read(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(USER_NOT_FOUND_ERROR));
    }
}
