package by.aghanim.user_service.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "mobile-phone")
public class MobileNumberProperty {
    private String mobilePhone;
}
