package datenbanken.utils;

import java.util.Scanner;

public class InputMenu {

    private final String[] menuItems;

    public InputMenu(String... menuItems) {
        this.menuItems = menuItems;
    }

    private void printMenu() {
        System.out.println();
        System.out.println();
        System.out.println("************");
        System.out.println("*** Menu ***");
        System.out.println("************");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("[" + i + "] - " + menuItems[i]);
        }
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);
        int eingabe;
        printMenu();

        do {
            System.out.print("Eingabe: ");
            try {
                eingabe = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ungültige Eingabe.");
                scanner.next();
                eingabe = -1;
            }
            if (eingabe >= 0 && eingabe < menuItems.length) {
                return eingabe;
            }
        } while (true);
    }

}
