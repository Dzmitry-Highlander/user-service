package by.aghanim.user_service;


import by.aghanim.user_service.config.properties.JWTProperty;
import by.aghanim.user_service.config.properties.MobileNumberProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableConfigurationProperties({MobileNumberProperty.class, JWTProperty.class})
@EnableJpaRepositories(basePackages = "by.aghanim.user_service.dao.api")
@EnableTransactionManagement
//TODO @EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
