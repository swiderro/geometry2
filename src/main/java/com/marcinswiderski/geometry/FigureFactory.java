package com.marcinswiderski.geometry;

import com.marcinswiderski.exception.IllegalArgumentsNumberException;
import com.marcinswiderski.exception.NotFoundException;

import java.util.List;

public class FigureFactory {

    public enum FigureEnum {
        RECTANGLE {
            @Override
            public String getAreaArgumentsDescription() {
                return Rectangle.getAreaArgumentsDescription();
            }
        },
        DISK {
            @Override
            public String getAreaArgumentsDescription() {
                return Disk.getAreaArgumentsDescription();
            }
        },
        SQUARE {
            @Override
            public String getAreaArgumentsDescription() {
                return Square.getAreaArgumentsDescription();
            }
        };

        public abstract String getAreaArgumentsDescription();
    }

    public static Figure createFigure(List<String> arguments) {
        String figureName = null;
        try {
            figureName = arguments.remove(0);
            switch (FigureEnum.valueOf(figureName.toUpperCase())) {
                case RECTANGLE:
                    return new Rectangle(arguments.get(0), arguments.get(1));
                case DISK:
                    return new Disk(arguments.get(0));
                case SQUARE:
                    return new Square(arguments.get(0));
            }
        } catch (IllegalArgumentException exception) {
            throw new NotFoundException(figureName);
        } catch (IndexOutOfBoundsException exception) {
            throw new IllegalArgumentsNumberException(arguments.size());
        }
        throw new NotFoundException(figureName);
    }
}
