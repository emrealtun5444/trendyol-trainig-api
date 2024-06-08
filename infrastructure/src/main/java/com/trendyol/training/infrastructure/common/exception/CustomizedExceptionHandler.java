package com.trendyol.training.infrastructure.common.exception;

import com.trendyol.training.infrastructure.common.exception.model.ErrorDetailResponse;
import com.trendyol.training.infrastructure.common.exception.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorResponse> handleAnyException(Exception exception) {
        log.error("Exception message: {}, exception type: {}, stack trace: {}", exception.getMessage(), exception.getClass().getName(), "");
        var errorResponse = ErrorResponse.builder().build();
        errorResponse.setException("InternalServerException");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception) {
        final var errorResponse = new ErrorResponse("BusinessException");
        final var detailResponse = new ErrorDetailResponse(exception.getKey(), getMessage(exception.getKey(), exception.getArgs()));
        errorResponse.addError(detailResponse);

        log.warn("BusinessException Caused by: {}", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final var errors = ex.getBindingResult().getAllErrors().stream()
                .map(err -> ErrorDetailResponse.builder()
                        .message(err.getDefaultMessage())
                        .key(err.getObjectName())
                        .build()
                )
                .collect(Collectors.toList());
        var errorResponse = ErrorResponse.builder().errors(errors).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public String getMessage(String key, String[] args) {
        return messageSource.getMessage(key, args, Locale.ENGLISH);
    }

}