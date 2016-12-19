package com.marcinswiderski.command;

import java.util.List;

public abstract class CommandWithArguments implements Command, WithArguments {

    List<String> arguments;

    @Override
    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

}
