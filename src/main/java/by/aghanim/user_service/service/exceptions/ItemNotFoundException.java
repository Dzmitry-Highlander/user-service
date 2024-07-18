package by.aghanim.user_service.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ItemNotFoundException extends IllegalStateException {
    private String item;
}
