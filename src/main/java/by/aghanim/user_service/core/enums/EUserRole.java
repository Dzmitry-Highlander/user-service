package by.aghanim.user_service.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EUserRole {
    ROLE_ADMIN("Administrator"),
    ROLE_USER("User"),
    ROLE_SYSTEM("System");

    private final String role;
}
