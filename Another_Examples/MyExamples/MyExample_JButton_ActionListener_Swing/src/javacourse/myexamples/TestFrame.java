package javacourse.myexamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vika on 30.07.16.
 */
public class TestFrame extends JFrame {

    private JTextField textField;

    public TestFrame() {
        super("Test frame");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        button1.setActionCommand("Button 1 was pressed!");
        panel.add(button1);

        JButton button2 = new JButton("Button 2");
        button2.setActionCommand("Button 2 was pressed!");
        panel.add(button2);

        JButton button3 = new JButton("Button 3");
        button3.setActionCommand("Button 3 was pressed!");
        panel.add(button3);

        textField = new JTextField();
        textField.setColumns(23);
        panel.add(textField);

        ActionListener actionListener = new TestActionListener();

        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);

        /**
         * Пример создания анонимного класса
         * В данном случае, у ActionListener нет имени:
         * ActionListener actionListener  - ..
         * actionListener - и есть имя
         */
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //textField.setText(e.getActionCommand());
                System.out.println("Здесь работает анонимный класс!!!");
                System.out.println(e.getActionCommand());
            }
        });

        getContentPane().add(panel);
        setPreferredSize(new Dimension(320, 100));
    }
}
