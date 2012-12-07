package boa.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class CommandLine {
    private static Scanner s = new Scanner(System.in);

    private CommandLine() {}

    public static String getStringResponse(final String message) {
        System.out.print(String.format("[%s]: ", message));
        String response = s.next();

        System.out.println();
        return response;
    }

    public static int getIntResponse(final String message) {
        // Loop until an integer response is given.
        Integer response = null;
        while (response == null) {
            try {
                System.out.print(String.format("[%s]: ", message));
                response = s.nextInt();
            } catch (InputMismatchException e) {
                s.next();
            } finally {
                System.out.println();
            }
        }

        return response.intValue();
    }
}
