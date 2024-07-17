package by.aghanim.api_service.core.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @NotEmpty(message = "Mobile number can't be empty")
    @Size(min = 8, max = 15, message = "Mobile number length must be from 8 till 15 symbols")
    private String mobileNumber;

    @NotEmpty(message = "Password can't be empty")
    @Size(min = 4, max = 20, message = "Password length must be from 4 till 20 symbols")
    private String password;
}
