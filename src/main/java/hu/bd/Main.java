package hu.bd;

import java.util.Scanner;

public class Main {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Choose an option:");
        System.out.println("1. Add ToDo");
        System.out.println("2. ToDo list");
        System.out.println("0. Exit");

        option = scanner.nextInt();


        switch (option) {
            case 1:
                System.out.println("Add a ToDo to your list.");
                break;
            case 2:
                System.out.println("View ToDo list.");
                break;
            case 3:
                System.out.println("Exit.");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }
    public static void main(String[] args) {
    }
}