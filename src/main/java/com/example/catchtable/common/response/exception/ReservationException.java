package com.example.catchtable.common.response.exception;

import com.example.catchtable.common.response.status.ResponseStatus;
import lombok.Getter;

@Getter
public class ReservationException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public ReservationException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }

    public ReservationException(ResponseStatus exceptionStatus, String message) {
        super(message);
        this.exceptionStatus = exceptionStatus;
    }
}
