package machine;

import java.util.Scanner;

public class CoffeeMachine {
    Ingredients onBoard = new Ingredients(0, 0, 0,0, 0);
    Ingredients espresso = new Ingredients(250, 0, 16, 1,4);
    Ingredients latte = new Ingredients(350, 75, 20, 1,7);
    Ingredients cappuccino = new Ingredients(200, 100, 12, 1,6);

    public void takeMoney() {
        println("I gave you $" + onBoard.money);
        onBoard.money = 0;
        println("");
    }

    public void fill () {
        Ingredients ing = new Ingredients(
                getInt("Write how many ml of water the coffee machine has: "),
                getInt("Write how many ml of milk the coffee machine has: "),
                getInt("Write how many grams of coffee beans the coffee machine has: "),
                getInt("Write how many disposable cups of coffee do you want to add: "),
                0
        );
        onBoard.plus(ing);
    }

    public void buyCup() {
        String type = getString("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String err = "Sorry, not enough ";
        switch (makeCup(type)) {
            case 1: println("I have enough resources, making you a coffee!");
            case 10: return;
            case -1: println(err+"water!");
            case -2: println(err+"milk!");
            case -3: println(err+"coffee beans!");
            case -4: println(err+"disposable cups!");
        }
    }

    public int testCup(Ingredients ing) {
        int test = 0;
        test = onBoard.compareTo(ing);
        if (test > 0)
            onBoard.minus(ing);
        return test;
    }

    public int makeCup(String type) {
        switch (type) {
            case "1": return testCup(espresso);
            case "2": return testCup(latte);
            case "3": return testCup(cappuccino);
            case "back": return 10;
            default: return 0;
        }
    }

    public void getStat() {
        println("The coffee machine has:");
        println(onBoard.toString());
    }

    public void getMenu () {
        while (true) {
            String action = getString("Write action (buy, fill, take, remaining, exit): ");
                    switch (action) {
                        case "buy": buyCup(); break;
                        case "fill": fill(); break;
                        case "take": takeMoney(); break;
                        case "remaining": getStat(); break;
                        case "exit": return;
            }
            println("");
        }
    }

    public static void println(String string) {
        System.out.println(string);
    }
    public static void print(String string) {
        System.out.print(string);
    }

    public static String getString(String input) {
        Scanner scanner = new Scanner(System.in);
        println(input);
        return scanner.nextLine();
    }

    public static int getInt(String input) {
        return getInt(input, true);
    }

    public static int getInt(String input, boolean newLine) {
        Scanner scanner = new Scanner(System.in);
        if (newLine)
            println(input);
        else
            print(input);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        // base init
        cm.onBoard.plus(new Ingredients(400, 540, 120, 9, 550));
        // menu
        cm.getMenu();
    }
}
