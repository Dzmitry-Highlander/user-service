package by.aghanim.api_service.core.dto;

import by.aghanim.api_service.core.enums.EUserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    @NotEmpty(message = "Nickname can't be empty")
    private String nickname;

    @NotEmpty(message = "Mobile number can't be empty")
    @Size(min = 8, max = 15, message = "")
    private String mobileNumber;

    @NotEmpty(message = "")
    @Size(min = 4, message = "Password length must be from 4 till 20 symbols")
    private String password;

    @NotNull(message = "Role is mandatory")
    private EUserRole role;
}
