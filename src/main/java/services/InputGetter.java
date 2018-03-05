package services;

import java.util.Scanner;

public class InputGetter {

    private Scanner scanner = new Scanner(System.in);

    public String getStringInput(String message) {
        boolean incorrectInput = true;
        String input = "";

        while (incorrectInput) {
            System.out.println(message);
            input = scanner.nextLine();

            if (input.length() > 0) incorrectInput = false;
        }
        return input;
    }

    public Integer getIntegerInput(String message) {
        boolean incorrectInput = true;
        String userInput;

        while(incorrectInput) {
            System.out.println(message);
            userInput = getUserInput();
            Integer number = checkIfInputIsInt(userInput);

            if (number != null) return number;
        }
        return null;
    }

    public Long getLongInput(String message) {
        boolean incorrectInput = true;
        String userInput;

        while(incorrectInput) {
            System.out.println(message);
            userInput = getUserInput();
            Long number = checkIfInputIsLong(userInput);

            if (number != null) return number;
        }
        return null;
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    private Integer checkIfInputIsInt(String input) {
        try {
            return Integer.parseInt(input);

        } catch (IllegalArgumentException e ) {
            System.out.println("You didn\'t type a number!");
        }
        return null;
    }

    private Long checkIfInputIsLong(String input) {
        try {
            return Long.valueOf(input);

        } catch (IllegalArgumentException e) {
            System.out.println("You typed wrong signs!");
        }
        return null;
    }

    public void promptUserToPressEnter() {
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();
    }
}