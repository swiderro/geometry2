package com.marcinswiderski.runner;

import com.marcinswiderski.command.*;
import com.marcinswiderski.exception.NotFoundException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GeometryCalculatorConsoleRunner {
    private final InputStream input;
    private final PrintStream output;

    private GeometryCalculatorConsoleRunner(InputStream in, PrintStream out) {
        this.input = in;
        this.output = out;
    }

    public static void main(String[] args) {
        new GeometryCalculatorConsoleRunner(System.in, System.out).execute();
    }

    private void execute() {
        Command command = null;
        do {
            printPrompt();
            try {
                command = readCommand();
                command.execute(output);
            } catch (NotFoundException exception) {
                printCommandError(exception);
                Help.printHelp(output);
            }
        } while (!(command instanceof Quit));
    }

    private void printCommandError(NotFoundException exception) {
        output.println("Command not found: " + exception.getSearched());
    }

    private Command readCommand() {
        Scanner scanner = new Scanner(input);
        String inputLine = scanner.nextLine();
        String[] splitInputLine = inputLine.split("\\s");
        Command command = CommandFactory.fromString(splitInputLine[0]);
        if (command instanceof WithArguments) {
            ((WithArguments) command).setArguments(getArgumentsList(splitInputLine));
        }
        return command;
    }

    private List<String> getArgumentsList(String[] splitInputLine) {
        List<String> arguments = new ArrayList<>(Arrays.asList(splitInputLine));
        arguments.remove(0);
        return arguments;
    }

    private void printPrompt() {
        output.print("calculator > ");
        output.flush();
    }

}
