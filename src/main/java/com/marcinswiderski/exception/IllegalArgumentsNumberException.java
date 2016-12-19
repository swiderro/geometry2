package com.marcinswiderski.exception;

public class IllegalArgumentsNumberException extends RuntimeException {
    private final Integer illegalSize;

    public IllegalArgumentsNumberException(int size) {
        this.illegalSize = size;
    }

    @Override
    public String getMessage() {
        return "Illegal arguments number : " + illegalSize;
    }
}
