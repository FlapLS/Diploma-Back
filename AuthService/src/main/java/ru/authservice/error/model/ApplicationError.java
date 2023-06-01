package ru.authservice.error.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import ru.authservice.application.common.Constants;

/**
 * Ошибка приложения.
 *
 * @author Iurii Babalin.
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ApplicationError {
    /**
     * Тип ошибки приложения
     */
    private ErrorType errorType;

    /**
     * Сообщение об ошибке.
     */
    private String error;

    /**
     * Время ошибки.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime time;

    /**
     * Стутус, который возвращается при вызове ошибки.
     */
    private HttpStatus status;

    /**
     * Создание ошибки.
     *
     * @param error     текст ошибки.
     * @param errorType тип ошиби.
     * @param status    статус ошибки.
     * @return класс ошибки.
     */
    public ApplicationError(String error, ErrorType errorType, HttpStatus status) {
        this.error = error;
        this.errorType = errorType;
        this.status = status;
        this.time = LocalDateTime.now();
    }
}
