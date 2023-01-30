package com.st.challenge.commons.exceptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class BussinessException extends RuntimeException {

    private HttpStatus code;

    private String message;

}
