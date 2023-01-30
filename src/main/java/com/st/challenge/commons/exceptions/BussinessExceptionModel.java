package com.st.challenge.commons.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BussinessExceptionModel {

    private HttpStatus code;

    private String message;
}
