package hu.bd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddToDo {
    private final List<ToDo> toDoList = new ArrayList<>();

    public void addToDo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ToDo title");
        String title = scanner.nextLine();
        System.out.print("Enter ToDo description: ");
        String description  = scanner.nextLine();

        ToDo toDo = new ToDo(title,description);
        toDoList.add(toDo);

        System.out.println("ToDo added successfully!");
    }
}
