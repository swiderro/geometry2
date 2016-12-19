package com.marcinswiderski.command;

public class CommandFactory {

    public enum CommandEnum {
        HELP("help message"),
        QUIT("exit program");

        private String usageDescription;

        CommandEnum(String usageDescription) {
            this.usageDescription = usageDescription;
        }

        public String getUsageDescription() {
            return this.usageDescription;
        }
    }

    public static Command fromString(final String commandName) {
        try {
            switch (CommandFactory.CommandEnum.valueOf(commandName.toUpperCase())) {
                case HELP:
                    return new Help();
                case QUIT:
                    return new Quit();
            }
        } catch (IllegalArgumentException exception) {
            throw new CommandNotFoundException(commandName);
        }
        throw new CommandNotFoundException(commandName);
    }

}
