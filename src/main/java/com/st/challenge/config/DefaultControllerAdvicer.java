package com.st.challenge.config;

import com.st.challenge.commons.exceptions.BussinessException;
import com.st.challenge.commons.exceptions.BussinessExceptionModel;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@Slf4j
public class DefaultControllerAdvicer {

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<?> handleBussinessException(BussinessException exception) {
        BussinessExceptionModel bussinessExceptionModel = new BussinessExceptionModel();
        BeanUtils.copyProperties(exception, bussinessExceptionModel);
        return new ResponseEntity<>(bussinessExceptionModel, exception.getCode() != null ? exception.getCode() : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class, MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<?> handleBadRequestException(Exception exception) {
        log.error(exception.getMessage());
        BussinessExceptionModel bussinessExceptionModel = new BussinessExceptionModel();
        bussinessExceptionModel.setCode(HttpStatus.BAD_REQUEST);
        bussinessExceptionModel.setMessage(exception.getMessage());
        return new ResponseEntity<>(bussinessExceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception exception) {
        log.error(exception.getMessage());
        BussinessExceptionModel bussinessExceptionModel = new BussinessExceptionModel();
        bussinessExceptionModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
        bussinessExceptionModel.setMessage(exception.getMessage());
        return new ResponseEntity<>(bussinessExceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
