package direelf;

import java.util.Scanner;

public class App {
    private static int currentWaterVolume = 400;
    private static int currentMilkVolume = 540;
    private static int currentCoffeeBeansWeight = 120;
    private static int currentAmountOfDisposableCups = 9;
    private static int currentAmountOfMoney = 550;

    public static void main(String[] args) {
        userMenu();
    }

    private static void printCondition() {
        System.out.println("\nThe coffee machine has:\n" +
                currentWaterVolume + " ml of water\n" +
                currentMilkVolume + " ml of milk\n" +
                currentCoffeeBeansWeight + " g of coffee beans\n" +
                currentAmountOfDisposableCups + " disposable cups\n" +
                "$" + currentAmountOfMoney + " of money\n");
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String userAction = new Scanner(System.in).next();
            switch (userAction) {
                case "remaining":
                    printCondition();
                    break;
                case "buy":
                    toBuyCupOfCoffee();
                    break;
                case "fill":
                    toFillWithIngredients();
                    break;
                case "take":
                    toTakeMoney();
                    break;
                case "exit":
                    return;
            }
        }
    }

    private static void toBuyCupOfCoffee() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String userInput = new Scanner(System.in).next();
        int usersChoice = userInput.equals("back") ? 4 : Integer.parseInt(userInput);
        if (enoughResources(usersChoice)) {
            switch (usersChoice) {
                case 1:
                    makeEspresso();
                    break;
                case 2:
                    makeLatte();
                    break;
                case 3:
                    makeCappuccino();
                case 4:
                    break;
            }
        }
    }

    private static boolean enoughResources(int usersChoice) {
        boolean answer = true;
        switch (usersChoice) {
            case 1 :
                if (currentWaterVolume < 250) {
                    answer = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (currentCoffeeBeansWeight < 16) {
                    answer = false;
                    System.out.println("Sorry, not enough coffee beans!");
                }
                if (currentAmountOfDisposableCups < 1) {
                    answer = false;
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case 2 :
                if (currentWaterVolume < 350) {
                    answer = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (currentMilkVolume < 75) {
                    answer = false;
                    System.out.println("Sorry, not enough milk!");
                }
                if (currentCoffeeBeansWeight < 20) {
                    answer = false;
                    System.out.println("Sorry, not enough coffee beans!");
                }
                if (currentAmountOfDisposableCups < 1) {
                    answer = false;
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case 3 :
                if (currentWaterVolume < 200) {
                    answer = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (currentMilkVolume < 100) {
                    answer = false;
                    System.out.println("Sorry, not enough milk!");
                }
                if (currentCoffeeBeansWeight < 12) {
                    answer = false;
                    System.out.println("Sorry, not enough coffee beans!");
                }
                if (currentAmountOfDisposableCups < 1) {
                    answer = false;
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;

        }
        return answer;
    }

    private static void makeEspresso() {
        System.out.println("I have enough resources, making you a coffee!");
        currentWaterVolume -= 250;
        currentCoffeeBeansWeight -= 16;
        currentAmountOfMoney += 4;
        currentAmountOfDisposableCups -= 1;
    }

    private static void makeLatte() {
        System.out.println("I have enough resources, making you a coffee!");
        currentWaterVolume -= 350;
        currentMilkVolume -= 75;
        currentCoffeeBeansWeight -= 20;
        currentAmountOfMoney += 7;
        currentAmountOfDisposableCups -= 1;
    }

    private static void makeCappuccino() {
        System.out.println("I have enough resources, making you a coffee!");
        currentWaterVolume -= 200;
        currentMilkVolume -= 100;
        currentCoffeeBeansWeight -= 12;
        currentAmountOfMoney += 6;
        currentAmountOfDisposableCups -= 1;
    }

    private static void toFillWithIngredients() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water you want to add:");
        int waterToAdd = scanner.nextInt();
        currentWaterVolume += waterToAdd;
        System.out.println("Write how many ml of milk you want to add:");
        int milkToAdd = scanner.nextInt();
        currentMilkVolume += milkToAdd;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeansToAdd = scanner.nextInt();
        currentCoffeeBeansWeight += coffeeBeansToAdd;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cupsToAdd = scanner.nextInt();
        currentAmountOfDisposableCups += cupsToAdd;
    }

    private static void toTakeMoney() {
        System.out.println("\nI gave you " + currentAmountOfMoney + "$");
        currentAmountOfMoney = 0;
    }
}
