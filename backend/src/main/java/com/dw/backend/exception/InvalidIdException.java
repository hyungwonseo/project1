package com.dw.backend.exception;

public class InvalidIdException extends RuntimeException {

    private String fieldName;
    private String message;

    public InvalidIdException(String fieldName, String message) {
        super();
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
