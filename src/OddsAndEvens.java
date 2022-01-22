import java.util.Random;
import java.util.Scanner;

public class OddsAndEvens {
    public static void main(String[] args) {
        // All the variables
        String name;
        String game;
        int finger;
        int computer;
        int result;
        String spacer = "************************\n";

        // Object initializer
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Intro section
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        name = input.nextLine();

        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        game = input.next();

        if (game.equalsIgnoreCase("o")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else if (game.equalsIgnoreCase("e")) {
            System.out.println(name + " has picked evens! The computer will be odds.");
        } else {
            System.out.println("please try again");
        }

        System.out.println(spacer);

        System.out.print("How many \"fingers\" do you put out? ");
        finger = input.nextInt();

        computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \"fingers\".");

        System.out.println(spacer);

        result = finger + computer;
        System.out.println(finger + " + " + computer + " = " + result);

        if (result % 2 == 0) {
            System.out.println(result + " is ...even!");
            if (game.equalsIgnoreCase("e")) {
                System.out.println("That means " + name + " wins! :)");
            } else {
                System.out.println("That means the computer wins! :(");
            }
        } else {
            System.out.println(result + " is ...odd!");
            if (game.equalsIgnoreCase("o")) {
                System.out.println("That means " + name + " wins! :)");
            } else {
                System.out.println("That means the computer wins! :(");
            }
        }
        System.out.println(spacer);
    }
}
