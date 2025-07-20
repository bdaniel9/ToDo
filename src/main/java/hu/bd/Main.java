package hu.bd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final List<ToDo> toDoList = new ArrayList<>();
    private final ViewToDo viewToDo = new ViewToDo();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add ToDo");
            System.out.println("2. ToDo list");
            System.out.println("3. Save ToDos to file");
            System.out.println("4. Load ToDos from file");
            System.out.println("0. Exit");
            System.out.print("Option: ");

            option = scanner.nextInt();
            scanner.nextLine(); // buffer törlés

            switch (option) {
                case 0:
                    System.out.println("Goodbye.");
                    break;
                case 1:
                    AddToDo.addToDo(toDoList);
                    break;
                case 2:
                    viewToDo.display(toDoList);
                    break;
                case 3:
                    saveToFile();
                    break;
                case 4:
                    loadFromFile();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    public void saveToFile() {
        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdirs();
                System.out.println("Created folder: " + dir.getAbsolutePath());
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("data/todos.txt"));

            for (ToDo todo : toDoList) {
                writer.write(todo.toString());
                writer.newLine();
            }

            writer.close();
            System.out.println("ToDos saved to: " + new File("data/todos.txt").getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving ToDos: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        toDoList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/todos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                toDoList.add(ToDo.fromString(line));
            }
            System.out.println("ToDos loaded from file!");
        } catch (IOException e) {
            System.out.println("Error loading ToDos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Main().menu();
    }
}
