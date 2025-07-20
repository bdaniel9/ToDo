package hu.bd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Choose an option:");
        System.out.println("1. Add ToDo");
        System.out.println("2. ToDo list");
        System.out.println("0. Exit");

        System.out.print("Option: ");
        option = scanner.nextInt();

        switch (option) {
            case 0:
                System.out.println("Goodbye.");
                break;
            case 1:
                System.out.println("Add a ToDo to your list. ");
                break;
            case 2:
                System.out.println("View ToDo list.");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }
}