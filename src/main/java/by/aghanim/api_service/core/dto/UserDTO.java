package by.aghanim.api_service.core.dto;

import by.aghanim.api_service.core.enums.EUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID uuid;
    private String nickname;
    private String mobileNumber;
    private EUserRole role;
}
