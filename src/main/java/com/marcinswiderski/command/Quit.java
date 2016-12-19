package com.marcinswiderski.command;

import java.io.PrintStream;

public class Quit implements Command {


    @Override
    public void execute(PrintStream output) {
        printExitMessage(output);
        System.exit(0);
    }

    private void printExitMessage(PrintStream output) {
        output.println("Calculator says \"Goodbye!\"");
    }
}
