package boa.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class CommandLine {
    private static Scanner s = new Scanner(System.in);

    private CommandLine() {
        throw new UnsupportedOperationException();
    }

    public static void printlnIndented(final String message) {
        System.out.println(String.format("\t%s\n", message.replaceAll("\n", "\n\t")));
    }

    public static String getStringResponse(final String message) {
        System.out.print(String.format("[%s]: ", message));
        String response = CommandLine.s.next();

        System.out.println();
        return response;
    }

    public static int getIntResponse(final String message) {
        // Loop until an integer response is given.
        Integer response = null;
        while (response == null) {
            try {
                System.out.print(String.format("[%s]: ", message));
                response = CommandLine.s.nextInt();
            } catch (InputMismatchException e) {
                CommandLine.s.next();
            } finally {
                System.out.println();
            }
        }

        return response.intValue();
    }

    public static int getIntResponseWithinBounds(final int lower, final int upper,
            final String message) {
        int response;
        do {
            response = CommandLine.getIntResponse(String.format("%s (%d - %d)", message, lower,
                    upper));
        } while ((response < lower) || (response > upper));

        return response;
    }
}
