package com.marcinswiderski.exception;

public class NotFoundException extends RuntimeException {
    private String searched;

    public NotFoundException(String commandName) {
        this.searched = commandName;
    }

    public String getSearched() {
        return searched;
    }

}
