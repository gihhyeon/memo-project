package com.goormthon.memo_study.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    private ResponseEntity<ErrorResponseDto> handleCustomException(CustomException e) {
        log.error(e.getMessage(), e);
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(errorCode.getStatus(), errorCode.getMessage());
        return ResponseEntity.status(errorCode.getStatus()).body(errorResponseDto);
    }
}
