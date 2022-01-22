// Main program

import java.util.Scanner;

public class FractionCalculator {

    public static Scanner user = new Scanner(System.in);

    public static void main(String[] args) {
        intro();

//        Loop the program until user quit with Q
        while (true) {
            String ops = getOperation(user);
            Fraction fractionFirst = getFraction(user);
            Fraction fractionSecond = getFraction(user);

            Fraction result = new Fraction();
            String resultTemp = "";

            if (ops.equals("=")) {
                System.out.println(fractionFirst + " " + ops + " " + fractionSecond + " is " + fractionFirst.equals(fractionSecond));
            } else {
                if (ops.equals("+")) {
                    result = fractionFirst.add(fractionSecond);
                } else if (ops.equals("-")) {
                    result = fractionFirst.subtract(fractionSecond);
                } else if (ops.equals("/")) {
                    if (fractionSecond.getNumerator() == 0) {
                        resultTemp = "Invalid";
                    } else {
                        result = fractionFirst.divide(fractionSecond);
                    }
                } else if (ops.equals("*")) {
                    if (fractionSecond.getNumerator() == 0) {
                        resultTemp = "Invalid";
                    } else {
                        result = fractionFirst.multiply(fractionSecond);
                    }
                }

                if (resultTemp != "") {
                    System.out.println(fractionFirst + " " + ops + " 0 = " + fractionSecond);
                } else if (result.getNumerator() % result.getDenominator() == 0) {
                    System.out.println(fractionFirst + " " + ops + " " + fractionSecond + " = " + (result.getNumerator() / result.getDenominator()));
                } else {
                    System.out.println(fractionFirst + " " + ops + " " + fractionSecond + " = " + result.toString());
                }
            }
        }
    }

    public static void intro() {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("------------------------------------------------------------------------------");
    }

    public static String getOperation(Scanner input) {
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String ops = input.nextLine();
        boolean valid = true;

        while (valid) {
            if (ops.equals("q") || ops.equals("Q")) {
              System.exit(0);
            } else if (ops.equals("+") || ops.equals("-") || ops.equals("/") || ops.equals("*") || ops.equals("=")) {
                valid = false;
            } else {
                System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
                ops = input.nextLine();
            }
        }
        return ops;
    }

    public static boolean validFraction(String input) {
        boolean valid;

        // Check for negative
        if (input.startsWith("-")) {
            input = input.substring(1, input.length());
        }

        if (input.contains(" ") || input.contains("-") || input.charAt(input.indexOf("/") + 1) == '0') {
            valid = false;
        } else if (input.contains("/")) {
            input = input.replace("/", "");
        }

        // Check for positive integer using [matches]
        if (input.matches("[0-9]+")) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    public static Fraction getFraction(Scanner input) {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String ops = input.nextLine();

        // Use [validFraction] for condition of infinite loop until user get it right
        while (!validFraction(ops)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            ops = input.nextLine();
        }

        int nume = 0;
        int deno = 0;
        // Check and parse the numerator and denominator
        if (ops.contains("/")) {
            nume = Integer.parseInt(ops.substring(0, ops.indexOf("/")));
            deno = Integer.parseInt(ops.substring(ops.indexOf("/") + 1, ops.length()));
        } else {
            nume = Integer.parseInt(ops);
            deno = 1;
        }

        Fraction result = new Fraction(nume, deno);
        return result;
    }
}
