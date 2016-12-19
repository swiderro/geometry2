package com.marcinswiderski.command;

import com.marcinswiderski.exception.NotFoundException;

public class CommandFactory {

    public enum CommandEnum {
        HELP {
            @Override
            public String getUsageDescription() {
                return Help.getUsageDescription();
            }
        },
        QUIT {
            @Override
            public String getUsageDescription() {
                return Quit.getUsageDescription();
            }
        },
        AREA {
            @Override
            public String getUsageDescription() {
                return Area.getUsageDescription();
            }
        };

        public abstract String getUsageDescription();
    }

    public static Command fromString(final String commandName) {
        try {
            switch (CommandFactory.CommandEnum.valueOf(commandName.toUpperCase())) {
                case AREA:
                    return new Area();
                case HELP:
                    return new Help();
                case QUIT:
                    return new Quit();
            }
        } catch (IllegalArgumentException exception) {
            throw new NotFoundException(commandName);
        }
        throw new NotFoundException(commandName);
    }

}
