package hu.bd;

import java.util.List;

public class ViewToDo {

    public void display(List<ToDo> toDoList) {
        if (toDoList.isEmpty()) {
            System.out.println("No ToDo found!");
        } else {
            System.out.println("Your ToDos:");
            for (ToDo toDo : toDoList) {
                System.out.println("- " + toDo);
            }
        }
    }
}
