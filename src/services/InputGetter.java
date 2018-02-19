package services;

import java.util.Scanner;

public class InputGetter {

    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String message) {
        boolean incorrectInput = true;
        String userInput = "";

        while (incorrectInput) {
            System.out.println(message);
            userInput = scanner.nextLine();

            if (userInput.length() < 1) incorrectInput = false;
        }
        return userInput;
    }
}