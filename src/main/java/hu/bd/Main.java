package hu.bd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        private final List<ToDo> toDoList = new ArrayList<>();
        private final ViewToDo viewToDo = new ViewToDo();

        public void menu() throws IOException {
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
            }while (option!=0);
            scanner.close();
        }

    public void saveToFile() {
        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("data/todos.txt"));

            for (ToDo todo : toDoList) {
                writer.write(todo.toString());
                writer.newLine();
            }

            writer.close();
            System.out.println("ToDos saved to data/todos.txt");
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
            System.out.println("ToDos loaded from data/todos.txt");
        } catch (IOException e) {
            System.out.println("Error loading ToDos: " + e.getMessage());
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().menu();
    }
}