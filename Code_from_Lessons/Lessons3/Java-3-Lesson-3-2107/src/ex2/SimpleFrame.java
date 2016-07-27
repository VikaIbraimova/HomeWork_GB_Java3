package ex2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */
public class SimpleFrame extends JFrame {
    public SimpleFrame() throws HeadlessException {
        super("My Simple Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 400);
        //getContentPane().add(new JButton("My 1st button"));
        JPanel panel = new JPanel();

//        panel.setLayout(new FlowLayout());
//        panel.add(new JButton("Button"));
//        panel.add(new JButton("B"));
//        panel.add(new JButton("n"));
//        panel.add(new JButton("My first super button"));

//        panel.setLayout(new BorderLayout());
//        panel.add(new JButton("Button"), BorderLayout.NORTH);
//        panel.add(new JButton("B"), BorderLayout.EAST);
//        panel.add(new JButton("n"), BorderLayout.WEST);
//        panel.add(new JButton("Q"), BorderLayout.SOUTH);
//        panel.add(new JButton("My first super button"));

//        panel.setLayout(new GridLayout(2, 3, 10,20));
//        panel.add(new JButton("Button"));
//        panel.add(new JButton("B"));
//        panel.add(new JButton("n"));
//        panel.add(new JButton("Q"));
//        panel.add(new JButton("My first super button"));

//        setContentPane(panel);

        Box box = Box.createHorizontalBox();
        box.add(new JButton("Button"));
        box.add(Box.createHorizontalStrut(10));
        box.add(new JButton("B"));
        box.add(Box.createHorizontalGlue());
        box.add(new JButton("n"));
        box.add(Box.createHorizontalStrut(10));
        box.add(new JButton("Q"));
        box.add(new JButton("My first super button"));
        setContentPane(box);
    }
}
