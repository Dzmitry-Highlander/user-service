package by.aghanim.user_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//TODO @EnableConfigurationProperties({MailProperty.class, JWTProperty.class})
@EnableJpaRepositories(basePackages = "by.aghanim.user_service.dao.api")
@EnableTransactionManagement
//TODO @EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
