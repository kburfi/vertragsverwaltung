package com.burfi.vertragsverwaltung.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExceptionWithStatus extends RuntimeException {

    private final HttpStatus httpStatus;

    public ExceptionWithStatus(String message, HttpStatus httpStatus) {
        this(message, httpStatus, null);
    }

    public ExceptionWithStatus(String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

}
