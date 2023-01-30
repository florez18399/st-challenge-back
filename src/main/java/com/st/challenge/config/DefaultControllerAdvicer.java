package com.st.challenge.config;

import com.st.challenge.commons.exceptions.BussinessException;
import com.st.challenge.commons.exceptions.BussinessExceptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class DefaultControllerAdvicer {

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity handleBussinessException(BussinessException exception) {
        BussinessExceptionModel bussinessExceptionModel = new BussinessExceptionModel();
        BeanUtils.copyProperties(exception, bussinessExceptionModel);
        return new ResponseEntity<>(bussinessExceptionModel, exception.getCode() != null ? exception.getCode() : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGenericException(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>("En construcción", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
