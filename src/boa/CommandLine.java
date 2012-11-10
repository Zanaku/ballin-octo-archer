package boa;

import java.util.Scanner;

public class CommandLine {
    private static Scanner s = new Scanner(System.in);

    public static String getStringResponse(final String message) {
        System.out.print(String.format("[%s]: ", message));

        return CommandLine.s.next();
    }

    public static int getIntResponse(final String message) {
        System.out.print(String.format("[%s]: ", message));

        return CommandLine.s.nextInt();
    }
}
