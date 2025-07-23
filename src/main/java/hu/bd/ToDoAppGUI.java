package hu.bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoAppGUI {

    private static final List<ToDo> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("My ToDo App");
        JButton addButton = new JButton("Add ToDo");
        JButton listButton = new JButton("List ToDos");
        JButton deleteButton = new JButton("Delete ToDo");

        frame.setLayout(new FlowLayout());

        addButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Enter title:");
            String desc = JOptionPane.showInputDialog("Enter description:");

            if (title != null && desc != null && !title.isEmpty()) {
                toDoList.add(new ToDo(title, desc));
                ToDoFileHandler.saveToFile(toDoList);
                JOptionPane.showMessageDialog(frame, "ToDo added and saved!");
            }
        });


        listButton.addActionListener(e -> {
            toDoList.clear();
            toDoList.addAll(ToDoFileHandler.loadFromFile());

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (ToDo todo : toDoList) {
                sb.append(count++).append(". ").append(todo.userPrint()).append("\n---------------------\n");
            }

            textArea.setText(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));

            JOptionPane.showMessageDialog(frame, scrollPane, "Your ToDos", JOptionPane.INFORMATION_MESSAGE);
        });



        deleteButton.addActionListener(e -> {
            if (toDoList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No ToDos to delete.");
            } else {
                String input = JOptionPane.showInputDialog("Enter number of ToDo to delete:");
                try {
                    int index = Integer.parseInt(input) - 1;
                    if (index >= 0 && index < toDoList.size()) {
                        toDoList.remove(index);
                        ToDoFileHandler.saveToFile(toDoList);
                        JOptionPane.showMessageDialog(frame, "ToDo deleted and saved!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid index!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input!");
                }
            }
        });



        frame.getContentPane().add(addButton);
        frame.getContentPane().add(listButton);
        frame.getContentPane().add(deleteButton);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
