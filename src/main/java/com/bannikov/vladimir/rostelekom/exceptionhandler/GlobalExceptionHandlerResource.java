package com.bannikov.vladimir.rostelekom.exceptionhandler;

import com.bannikov.vladimir.rostelekom.exception.ResourceNotFoundException;
import com.bannikov.vladimir.rostelekom.model.dto.ApiErrorDto;
import com.bannikov.vladimir.rostelekom.service.DateTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.bannikov.vladimir.rostelekom.util.WebUtil.getFullRequestUri;

@RestControllerAdvice
@Slf4j
@Component
public class GlobalExceptionHandlerResource extends ResponseEntityExceptionHandler {

    private final DateTimeService dateTimeService;

    public GlobalExceptionHandlerResource(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.debug("In handleResourceNotFoundException - {}", e.getMessage());

        ApiErrorDto error = createApiError(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    private ApiErrorDto createApiError(String errorMessage) {
        return new ApiErrorDto.Builder()
                .withTimestamp(dateTimeService.now())
                .withErrorMessage(errorMessage)
                .withPath(getFullRequestUri())
                .build();
    }
}
