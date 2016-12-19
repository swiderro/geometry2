package com.marcinswiderski.command;

public class CommandNotFoundException extends RuntimeException {
    private String commandSearched;

    CommandNotFoundException(String commandName) {
        this.commandSearched = commandName;
    }

    public String getCommandSearched() {
        return commandSearched;
    }
}
