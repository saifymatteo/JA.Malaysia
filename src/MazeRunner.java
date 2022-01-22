import java.util.Scanner;

public class MazeRunner {

    public static Maze myMap = new Maze();
    public static int userMoves = 0;

    public static void main(String[] args) {
        intro();
        String player = "";

        while (!myMap.didIWin()) {
            player = userMove();
            navigatePit(player);
        }
        if (myMap.didIWin()) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + userMoves + " moves");
        }

        System.out.println(player);
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static String userMove() {
        Scanner input = new Scanner(System.in);
        String user = "";

        while (true) {
            System.out.print("Where would you like to move? (R, L, U, D): ");
            user = input.next().toUpperCase();

            if (user.equals("R")) {
                if (myMap.canIMoveRight()) {
                    myMap.moveRight();
                    userMoves++;
                    movesMessage(userMoves);
                    myMap.printMap();
                } else {
                    System.out.println("[R] Sorry, you've hit a wall.");
                }
            } else if (user.equals("L")) {
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                    userMoves++;
                    movesMessage(userMoves);
                    myMap.printMap();
                } else {
                    System.out.println("[L] Sorry, you've hit a wall.");
                }
            } else if (user.equals("U")) {
                if (myMap.canIMoveUp()) {
                    myMap.moveUp();
                    userMoves++;
                    movesMessage(userMoves);
                    myMap.printMap();
                } else {
                    System.out.println("[U] Sorry, you've hit a wall.");
                }
            } else if (user.equals("D")) {
                if (myMap.canIMoveDown()) {
                    myMap.moveDown();
                    userMoves++;
                    movesMessage(userMoves);
                    myMap.printMap();
                } else {
                    System.out.println("[D] Sorry, you've hit a wall.");
                }
            }
            System.out.println("Current moves: " + userMoves);
            break;
        }
        return user;
    }

    public static void movesMessage(int moves) {
        if (moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moves == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moves == 100) {
            System.out.println(" Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        } else if (moves == 101) {
            System.out.println("Sorry, but you didn't escape in time- you lose!");
            System.exit(0); // End the game abruptly
        }
    }

    public static void navigatePit(String player) {
        Scanner input = new Scanner(System.in);
        if (myMap.isThereAPit(player)) {
            System.out.print("WATCH OUT! There's a pit ahead, jump it? ");
            String jump = input.next().toUpperCase();

            if (jump.equals("YES") || jump.startsWith("Y")) {
                myMap.jumpOverPit(player);
                myMap.printMap();
            } else {
                System.out.println("Sorry, but you didn't jump- you lose!");
                System.exit(0);
            }
        }
    }
}