package hu.bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoAppGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My ToDo App");

        JButton button = new JButton("Add ToDo");
        JButton button1 = new JButton("List ToDos");
        JButton button2 = new JButton("Delete ToDo");

        // Layout: automatikusan balról jobbra teszi a gombokat
        frame.setLayout(new FlowLayout());

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter title:");
                String desc = JOptionPane.showInputDialog("Enter description:");
                System.out.println("New ToDo: " + title + " - " + desc);
            }
        });

        button1.addActionListener(e -> System.out.println("List ToDos clicked"));
        button2.addActionListener(e -> System.out.println("Delete ToDo clicked"));

        // MINDHÁROM GOMBOT HOZZÁ KELL ADNI
        frame.getContentPane().add(button);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
