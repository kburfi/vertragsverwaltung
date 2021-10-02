package com.burfi.vertragsverwaltung.common.exception;

import lombok.Data;

@Data
class ErrorBody {
    private String message;
    private String debugMessage;

    ErrorBody(ExceptionWithStatus e) {
        this.message = e.getMessage();
        if (e.getCause() != null) {
            this.debugMessage = e.getCause().getLocalizedMessage();
        }
    }

}