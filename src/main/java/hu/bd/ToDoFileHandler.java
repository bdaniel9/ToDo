package hu.bd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoFileHandler {

    private static final String FILE_PATH = "data/todos.txt";

    public static void saveToFile(List<ToDo> toDoList) {
        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (ToDo todo : toDoList) {
                    writer.write(todo.toString());
                    writer.newLine();
                }
            }

            System.out.println("ToDos saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving ToDos: " + e.getMessage());
        }
    }

    public static List<ToDo> loadFromFile() {
        List<ToDo> toDoList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                toDoList.add(ToDo.fromString(line));
            }
            System.out.println("ToDos loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading ToDos: " + e.getMessage());
        }

        return toDoList;
    }
}
