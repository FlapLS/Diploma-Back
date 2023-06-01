package ru.authservice.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import ru.authservice.error.exception.ApplicationException;
import ru.authservice.error.model.ApplicationError;
import ru.authservice.error.model.ErrorType;

@Getter
@AllArgsConstructor
public enum ErrorDescriptor {

    ERROR_CREATE_TOKEN("Ошибка в создании токена", ErrorType.APP, HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_READ_TOKEN("Ошибка в чтении токена", ErrorType.APP, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_AUTH_PROBLEM("Логин или пароль неверный", ErrorType.APP, HttpStatus.BAD_REQUEST),
    USER_TOKEN_ACCESS_NOT_FOUND("Токен доступа с заданным идентификатором не найден", ErrorType.APP,
            HttpStatus.BAD_REQUEST),
    USER_LOGOUT_LAST("Пользователь уже вышел", ErrorType.APP, HttpStatus.BAD_REQUEST),
    UNAUTHORIZED_ACCESS("Неавторизованный доступ", ErrorType.APP, HttpStatus.UNAUTHORIZED),
    ACCESS_DENIED("Недостаточно прав для доступа к ресурсу", ErrorType.APP, HttpStatus.FORBIDDEN),
    INTERNAL_SERVER_ERROR("Неожиданная ошибка сервиса", ErrorType.APP, HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("Запрошенный ресурс (интерфейс) не существует", ErrorType.APP, HttpStatus.NOT_FOUND);


    private final String message;

    private final ErrorType type;

    private final HttpStatus status;

    public void exception() {
        throw ApplicationException.of(applicationError());
    }

    public ApplicationException throwApplication() {
        return ApplicationException.of(applicationError());
    }

    public void throwIsTrue(Boolean flag) {
        if (flag) {
            exception();
        }
    }

    public void throwIsFalse(Boolean flag) {
        if (!flag) {
            exception();
        }
    }

    public void throwIsNull(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            exception();
        }
    }

    public ApplicationError applicationError() {
        return new ApplicationError(this.message, this.type, this.status);
    }

}
