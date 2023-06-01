package ru.authservice.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.authservice.error.model.ApplicationError;

@Getter
@AllArgsConstructor(staticName = "of")
public class ApplicationException extends RuntimeException {
    private ApplicationError error;
}
