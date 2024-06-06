package com.ecfcode.hexagonal.domain.exception;

public class DomainException extends RuntimeException {
    public DomainException(final String message) {
        super(message);
    }
}
