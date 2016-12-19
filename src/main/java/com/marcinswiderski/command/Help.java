package com.marcinswiderski.command;

import java.io.PrintStream;
import java.util.stream.Stream;

import static com.marcinswiderski.command.CommandFactory.CommandEnum.values;

public class Help implements Command {


    @Override
    public void execute(PrintStream output) {
        printHelp(output);
    }

    public static void printHelp(PrintStream output) {
        final StringBuilder sb = new StringBuilder("Usage:\n");
        Stream.of(values()).forEach(
            commandEnum -> sb.append(commandEnum.toString().toLowerCase())
                .append(" - ")
                .append(commandEnum.getUsageDescription())
                .append("\n")
        );
        output.println(sb.toString());

    }

    static String getUsageDescription() {
        return "help message";
    }
}
