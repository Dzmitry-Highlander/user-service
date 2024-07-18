package by.aghanim.user_service.config;

import by.aghanim.user_service.dao.api.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private static final String USER_NOT_FOUND = ""; //TODO String

    private final IUserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService(IUserRepository userRepository) {
        return username -> userRepository.findByMobileNumber(username)
                .orElseThrow(); //TODO new UsernameNotFoundException(USER_NOT_FOUND_ERROR));
    }

    //TODO public AuthenticationProvider authenticationProvider();

    //TODO  public AuthenticationManager authenticationManager();

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
