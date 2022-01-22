import java.util.Scanner;

// Simple terminal application to plan user trips

public class TripPlanner {

    static String name;
    static String city;
    static int days;
    static int hours;
    static int minutes;
    static int money;
    static double daily_spend;
    static String currency;
    static double exchange;
    static double exchange_rate;
    static double exchange_daily;
    static int time;
    static int time_midnight;
    static int time_noon;
    static double square_area;
    static double miles_area;

    static int round_int;
    static double round_double;

    public static void main(String[] args) {
        System.out.println("Welcome to Vacation Planner!");
        greeting();
        spacer();
        travelTimeAndBudget();
        spacer();
        timeDifference();
        spacer();
        countrySize();
        spacer();
    }

    public static void spacer() {
        System.out.println();
        System.out.println("***********");
        System.out.println();
    }

    public static void greeting() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        city = input.nextLine();
        System.out.print("Great! " + city + " sounds like a great trip");
    }

    public static void travelTimeAndBudget() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        currency = input.next();
        System.out.print("How many " + currency + " are there in 1 USD? ");
        exchange = input.nextDouble();

        hours = 24 * days;
        minutes = 60 * hours;

        daily_spend = (double) money / days;
        // Rounding number to 2 decimal
        round_int = (int) (daily_spend * 100);
        round_double = round_int / 100.0;
        daily_spend = round_double;

        exchange_rate = money * exchange;
        exchange_daily = exchange_rate / days;
        // Rounding number to 2 decimal
        round_int = (int) (exchange_daily * 100);
        round_double = round_int / 100.0;
        exchange_daily = round_double;

        System.out.println();
        System.out.println("If you are travelling for " + days + " days that is the same as " + hours + " hours or " + minutes + " minutes");
        System.out.println("If you are going to spend $" + money + " USD that means per day you can spend up to $" + daily_spend + " USD");
        System.out.print("Your total budget in " + currency + " is " + exchange_rate + " " + currency + ", which per day is " + exchange_daily + " " + currency);
    }

    public static void timeDifference() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        time = input.nextInt();

        time_midnight = time % 24; // TODO: Need to work on the calculation
        time_noon = 12 + time_midnight;
        System.out.print("That means that when it is midnight at home it will be " + time_midnight + ":00 in your travel destination and when it is noon at home it will be " + time_noon + ":00");
    }

    public static void countrySize() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        square_area = input.nextDouble();

        miles_area = square_area / 2.59;
        // Rounding number to 2 decimal
        round_int = (int) (miles_area * 100);
        round_double = round_int / 100.0;
        miles_area = round_double;

        System.out.print("In miles2 that is " + miles_area);
    }
}