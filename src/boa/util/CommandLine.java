package boa.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bunch of helper functions for pooting to the command line.
 */
public final class CommandLine {
    private static Scanner s = new Scanner(System.in);

    /**
     * Constructor -- cannot be called.
     */
    private CommandLine() {
        throw new UnsupportedOperationException();
    }

    /**
     * Prints the provided lines indented. Any new lines will also be intended.
     * Ends with a new line.
     * @param message Messages to be printed.
     */
    public static void printlnIndented(final String message) {
        System.out.println(String.format("\t%s\n", message.replaceAll("\n", "\n\t")));
    }

    public static String getStringResponse(final String message) {
        System.out.print(String.format("[%s]: ", message));
        String response = CommandLine.s.next();

        System.out.println();
        return response;
    }

    /**
     * Gets an integer input from the user. Keeps asking until a valid response
     * is given.
     * @param message Message to be asked
     * @return Integer the user input
     */
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

    /**
     * Gets an integer input from the user within the provided bounds. Keeps
     * asking until a valid response within those bounds is given.
     * @param lower Lower boundary
     * @param upper Upper boundary
     * @param message Message to be asked
     * @return Integer the user input
     */
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
