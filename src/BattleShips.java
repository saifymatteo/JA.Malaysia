import java.util.Random;
import java.util.Scanner;

public class BattleShips {

    public static Scanner input = new Scanner(System.in);
    public static Random ranNum = new Random();

    public static String[][] oceanPlayer = new String[10][10]; // 10x10 grid of the ocean
    public static String[][] oceanComp = new String[10][10];

    public static int playerShip = 0;
    public static int compShip = 0;

    public static void main(String[] args) {
        begin();
        setPlayerShip();
        setCompShip();
        battle();
    }

    public static void begin() {
        // Game begin with texts and print the empty Map
        System.out.println("**** Welcome to Battle Ships game ****\n");
        System.out.println("Right now, the sea is empty.");
        oceanMap();
    }

    public static void oceanMap() {
        // Generate map
        System.out.println("\n   0123456789");

        for (int r = 0; r < oceanPlayer.length; r++) {
            System.out.print(r + " |");

            for (int c = 0; c < oceanPlayer[r].length; c++) {
                if (oceanPlayer[r][c] == null) {
                    System.out.print(" "); // For first start, put space
                } else {
                    System.out.print(oceanPlayer[r][c]); // This is for later generate only
                }
            }

            System.out.println("| " + r);
        }

        System.out.println("   0123456789\n");
    }

    public static void setPlayerShip() {
        System.out.println("Deploy your ships:");

        while (playerShip < 5) {
            System.out.print("Enter X coordinate for your " + (playerShip + 1) + ". ship: ");
            int r = input.nextInt();
            System.out.print("Enter Y coordinate for your " + (playerShip + 1) + ". ship: ");
            int c = input.nextInt();

            if (r > 9 || c > 9) {
                System.out.println("Out of range, please try again"); // Checking for out of bound
            } else if (oceanPlayer[r][c] != null) {
                System.out.println("Already in used, please try again"); // Checking for empty element
            } else {
                oceanPlayer[r][c] = "@";
                playerShip += 1;
            }
        }
    }

    public static void setCompShip() {
        System.out.println("Computer is deploying ships");

        while (compShip < 5) {
            int r = ranNum.nextInt(10); // Making sure computer ship stays in 0-9 only
            int c = ranNum.nextInt(10);

            if (oceanPlayer[r][c] == null && oceanComp[r][c] == null) {
                System.out.println((compShip + 1) + ". ship DEPLOYED"); // Checking against empty element on player & computer side
                oceanComp[r][c] = "@";
                compShip += 1;
            }
        }
    }

    public static void oceanCompMap() {
        // Generate map
        System.out.println("\n   0123456789");

        for (int r = 0; r < oceanComp.length; r++) {
            System.out.print(r + " |");

            for (int c = 0; c < oceanComp[r].length; c++) {
                if (oceanComp[r][c] == null) {
                    System.out.print(" "); // For first start, put space
                } else {
                    System.out.print(oceanComp[r][c]); // This is for later generate only
                }
            }

            System.out.println("| " + r);
        }

        System.out.println("   0123456789\n");
    }

    public static void playerTurn() {
        System.out.println("YOUR TURN");

        boolean validMove = true; // Initialize valid move turn

        while (validMove) {
            System.out.print("Enter X coordinate: ");
            int r = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            int c = input.nextInt();

            if (r > 9 || c > 9) {
                System.out.println("Out of range, please try again"); // Checking for out of bounds
            }
            else if (oceanPlayer[r][c] == "!" || oceanPlayer[r][c] == "x" || oceanPlayer[r][c] == "-") {
                System.out.println("Already used, please try again"); // Checking for used guess
            }
            else if (oceanComp[r][c] == "@") {
                System.out.println("Boom! You sunk the ship!"); // Player managed to hit computer ships
                oceanPlayer[r][c] = "!";
                oceanComp[r][c] = "!";
                compShip -= 1;
                validMove = false;
            }
            else if (oceanPlayer[r][c] == "@") {
                System.out.println("Oh no, you sunk your own ship :("); // Player shot their own ship
                oceanPlayer[r][c] = "x";
                oceanComp[r][c] = "x";
                playerShip -= 1;
                validMove = false;
            }
            else {
                System.out.println("Sorry, you missed"); // Player missed
                oceanPlayer[r][c] = "-";
                validMove = false;
            }
        }
    }

    public static void compTurn() {
        System.out.println("COMPUTER'S TURN");

        boolean validMove = true;

        while (validMove) {
            int r = ranNum.nextInt(10);
            int c = ranNum.nextInt(10);

            if (oceanPlayer[r][c] == "@") {
                System.out.println("The Computer sunk one of your ships!");
                oceanPlayer[r][c] = "x";
                oceanComp[r][c] = "x";
                playerShip -= 1;
                validMove = false;
            }
            else if (oceanComp[r][c] == "@") {
                System.out.println("The Computer sunk one of its own ships");
                oceanComp[r][c] = "!";
                oceanPlayer[r][c] = "!";
                compShip -= 1;
                validMove = false;
            }
            else {
                System.out.println("Computer missed");
                oceanComp[r][c] = "-";
                validMove = false;
            }
        }
    }

    public static void battle() {
        while (playerShip > 0 && compShip > 0) {
            playerTurn();
            compTurn();
            oceanMap();
            System.out.println("Your ships: " + playerShip + " | Computer ships: " + compShip);
            System.out.println("----------------------------");
        }

        if (playerShip == 0) {
            System.out.println("**** GAME OVER ****");
        } else {
            System.out.println("Hooray! You win the battle :)");
        }
    }
}
