package com.ripple.infrasvc.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;


/**
 * Created by sumit.nagariya on 19/09/19.
 */
@ControllerAdvice
@RestController
public class ExceptionHandlerControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public
    @ResponseBody
    ExceptionResponse handleException(final Exception exception,
                                      final HttpServletRequest request) {
        LOGGER.error("Error occured:", exception);
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public
    @ResponseBody
    ExceptionResponse handleMethodArgumentNotValid(final MethodArgumentNotValidException exception,
                                                   final HttpServletRequest request) {
        LOGGER.error("Error occured:", exception);
        ExceptionResponse error = new ExceptionResponse();
        String errorMessage = exception.getBindingResult().getFieldErrors().stream().map(t ->
                t.getDefaultMessage()).collect(Collectors.joining(","));
        error.setErrorMessage(errorMessage);
        error.callerURL(request.getRequestURI());
        return error;
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(CustomException exception, HttpServletRequest request) {
        LOGGER.error("Error occured:", exception);
        ExceptionResponse apiError = new ExceptionResponse();
        apiError.setErrorMessage(exception.getMessage());
        apiError.callerURL(request.getRequestURI());
        return new ResponseEntity<ExceptionResponse>(apiError, null, exception.getHttpStatus());
    }


}
