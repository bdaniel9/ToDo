package hu.bd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        private final List<ToDo> toDoList = new ArrayList<>();
        private final ViewToDo viewToDo = new ViewToDo();

        public void menu() {
            Scanner scanner = new Scanner(System.in);
            int option;

            do{

            System.out.println("Choose an option:");
            System.out.println("1. Add ToDo");
            System.out.println("2. ToDo list");
            System.out.println("0. Exit");

            System.out.print("Option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Goodbye.");
                    break;
                case 1:
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter description: ");
                    String description = scanner.nextLine();
                    toDoList.add(new ToDo(title,description));
                    System.out.println("Todo added!");
                    break;
                case 2:
                    System.out.println("Show ToDo list.");
                    viewToDo.display(toDoList);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            }while (option!=0);
            scanner.close();
        }

    public static void main(String[] args) {
        new Main().menu();
    }
}