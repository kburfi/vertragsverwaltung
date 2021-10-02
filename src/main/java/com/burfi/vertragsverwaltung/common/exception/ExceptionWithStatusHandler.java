package com.burfi.vertragsverwaltung.common.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionWithStatusHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExceptionWithStatus.class)
    protected ResponseEntity<Object> handleEntityNotFound(ExceptionWithStatus ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorBody(ex));
    }

}
