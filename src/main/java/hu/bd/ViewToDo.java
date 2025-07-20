package hu.bd;

import java.text.AttributedCharacterIterator;
import java.util.List;

public class ViewToDo {

    public void display(List<ToDo> toDoList) {
        int count=0;
        if (toDoList.isEmpty()) {
            System.out.println("No ToDo found!");
        } else {
            System.out.println("Your ToDos:");
            for (ToDo toDo : toDoList) {
                count++;
                System.out.println(count+". "+toDo.userPrint());
                System.out.println("---------------------");
            }
        }
    }
}
