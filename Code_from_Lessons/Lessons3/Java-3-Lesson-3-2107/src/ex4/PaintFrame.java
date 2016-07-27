package ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */
public class PaintFrame extends JFrame {
    Color color = Color.black;
    //FIXME: Реализовать сохранение цвета нарисованных линий.
    List<Line2D.Float> lines = new ArrayList<>();
    DrawPanel panel;
    Point lastPoint;

    public PaintFrame(String title) throws HeadlessException {
        super(title);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());
        panel = new DrawPanel();
        DrawListener drawListener = new DrawListener();
        panel.addMouseListener(drawListener);
        panel.addMouseMotionListener(drawListener);
        add(panel);
        add(new ButtonPanel(),BorderLayout.NORTH);
    }

    private class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = ((Graphics2D) g);
            g2d.setColor(color);
            for (Line2D.Float line: lines) {
                g2d.draw(line);
            }
        }
    }

    private class ButtonPanel extends JPanel implements ActionListener {
        public static final String RED = "red";
        public static final String GREEN = "green";
        public static final String BLUE = "blue";
        public static final String BLACK = "black";
        JButton btnRed;
        JButton btnBlack;
        JButton btnBlue;
        JButton btnGreen;

        public ButtonPanel() {
            //FIXME: исправить так, чтобы не приходилось дублировать указание цвета
            initButton(btnRed, RED, Color.RED);
            initButton(btnGreen, GREEN, Color.GREEN);
            initButton(btnBlue, BLUE, Color.BLUE);
            initButton(btnBlack, BLACK, Color.BLACK);
        }

        private  void initButton(JButton button, String name, Color color ){
            button = new JButton();
            button.setBackground(color);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setActionCommand(name);
            button.addActionListener(this);
            add(button);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //FIXME: реализовать вместо switch, Map
            switch (e.getActionCommand()){
                case RED:
                    color = Color.RED;
                    break;
                case GREEN:
                    color = Color.GREEN;
                    break;
                case BLUE:
                    color = Color.BLUE;
                    break;
                case BLACK:
                    color = Color.BLACK;
                    break;
            }
            System.out.println("You changed color.");
        }
    }

    private class DrawListener extends MouseAdapter{
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            Point point = e.getPoint();
            if (lastPoint == null) {
                lastPoint = point;
                return;
            }
            lines.add(new Line2D.Float(lastPoint, point));
            lastPoint = point;
            panel.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            lastPoint = null;
        }
    }

    public static void main(String[] args) {
        PaintFrame paintFrame = new PaintFrame("My Super Paint");
        paintFrame.setVisible(true);
    }
}
