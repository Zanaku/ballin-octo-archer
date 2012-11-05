package boa;

import java.util.Scanner;

import boa.domain.Player;

public class BallinOctoArcher {
    private Player player;

    public void printWelcome() {
        System.out.println("===================================\n"
                + "= Welcome to Ballin-Octo-Archter! =\n"
                + "===================================\n" + "\n");
    }

    public void createCharacter() {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String characterName = s.nextLine();
        System.out.println();

        this.player = new Player(characterName);
        s.close();
    }

    public static void main(String[] args) {

    }
}
