package com.marcinswiderski.command;

import java.io.PrintStream;

public interface Command {

    void execute(PrintStream output);
}
