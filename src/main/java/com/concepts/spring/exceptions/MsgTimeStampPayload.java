package com.concepts.spring.exceptions;

import java.time.ZonedDateTime;

public class MsgTimeStampPayload {
    private final String message;
    private final ZonedDateTime timeStamp;

    public MsgTimeStampPayload(String message, ZonedDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
