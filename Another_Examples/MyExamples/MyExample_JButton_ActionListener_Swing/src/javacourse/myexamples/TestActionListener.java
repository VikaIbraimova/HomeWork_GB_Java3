package javacourse.myexamples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vika on 30.07.16.
 */
public class TestActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //textField.setText(e.getActionCommand());
        System.out.println(e.getActionCommand());
    }
}

