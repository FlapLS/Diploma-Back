package ru.authservice.application.common;

import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.authservice.error.ErrorDescriptor;
import ru.authservice.error.exception.ApplicationException;
import ru.authservice.error.model.ApplicationError;

/**
 * Обработка ошибок приложения.
 *
 * @author Iurii Babalin.
 */
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    /**
     * Обработка исключения {@link NoHandlerFoundException}.
     *
     * @param ex исключение.
     * @return ошибка приложения.
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ApplicationError handleError404(NoHandlerFoundException ex) {
        log.error(ErrorDescriptor.NOT_FOUND.getMessage());
        return ErrorDescriptor.NOT_FOUND.applicationError();
    }


    /**
     * Обработка ошибки приложения {@link ApplicationException}.
     *
     * @param ex исключение.
     * @return ошибка приложения.
     */
    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ApplicationError applicationException(ApplicationException ex, HttpServletResponse response) {
        response.setStatus(ex.getError().getStatus().value());
        log.error(ex.getError().getError());
        return ex.getError();
    }


    /**
     * Обработка исключения {@link Exception}.
     *
     * @param ex исключение.
     * @return ошибка приложения.
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApplicationError exception(Exception ex, HttpServletResponse response) {
        log.info(ex.getMessage());
        response.setStatus(ErrorDescriptor.INTERNAL_SERVER_ERROR.getStatus().value());
        return ErrorDescriptor.INTERNAL_SERVER_ERROR.applicationError();
    }

}
