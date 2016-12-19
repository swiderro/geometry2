package com.marcinswiderski.command;

import com.marcinswiderski.exception.IllegalArgumentsNumberException;
import com.marcinswiderski.exception.NotFoundException;
import com.marcinswiderski.geometry.Figure;
import com.marcinswiderski.geometry.FigureFactory;

import java.io.PrintStream;
import java.util.stream.Stream;

public class Area extends CommandWithArguments {
    @Override
    public void execute(PrintStream output) {
        try {
            Figure figure = FigureFactory.createFigure(arguments);
            output.println("Area of " + figure.getFigureDescription() + " is " + figure.getArea());
        } catch (NotFoundException e) {
            output.println("Figure not found: " + e.getSearched());
        } catch (IllegalArgumentsNumberException e) {
            output.println(e.getMessage());
        }
    }

    static String getUsageDescription() {
        StringBuilder sb = new StringBuilder("calculate area of a figure with given required info (side(s)/height/radius)\n");
        sb.append("\tpossible values are\n");
        Stream.of(FigureFactory.FigureEnum.values())
            .forEach(
                figureEnum -> sb.append("\t").append(figureEnum.toString())
                    .append(" ").append(figureEnum.getAreaArgumentsDescription())
                    .append(" ").append("\n")
            );
        return sb.toString();
    }
}
