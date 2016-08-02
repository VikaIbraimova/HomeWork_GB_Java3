package ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */

/**
 * Задача создать Paint, котрый рисует 8-ми цветами
 */
public class PaintFrame extends JFrame {
    //Выставляем по умолчанию цвет кисти
    Color color = Color.black;
    //FIXME: Реализовать сохранение цвета нарисованных линий.
    /**
     * Нарисованные линии будут хранится в ArrayList
     * Тип элментов: Line2D.Float - линии
     */
    List<ColoredLine> lines = new ArrayList<>();
    //Область, в которой будем рисовать
    DrawPanel panel;
    //Координаты первой точки - начало линии
    Point lastPoint;

    //HomeWork
    class ColoredLine{
        Line2D.Float line;
        Color color;

        public ColoredLine(Line2D.Float line, Color color) {
            this.line = line;
            this.color = color;
        }
    }


    /**
     * Панель DrawPanel - здесь мы рисуекм
     * Это,кстати, внутренний класс!!!
     */
    private class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            //Конструктор предка
            super.paintComponent(g);
            /**
             * Графику, которая к нам пришла - Graphics g
             * мы приводик к типу Graphics2D, тоесть кастим
             */
            Graphics2D g2d = ((Graphics2D) g);
            //После каста мы можем с графикой работать
            //Задаем цвет линии.По умолчанию определен вверху
            g2d.setColor(color);
            /**
             * Отрисовываем линии
             */
            for (ColoredLine line: lines) {
                g2d.setColor(line.color);
                g2d.draw(line.line);
            }
            g2d.setColor(color);
        }
    }

    /**
     * Панель ButtonPanel - здесь располодены кнопки
     * Это, кстати тоже,внутренний класс
     */
    private class ButtonPanel extends JPanel implements ActionListener {
        /**
         * Обявд=ление кнопок
         */
        public static final String RED = "red";
        public static final String GREEN = "green";
        public static final String BLUE = "blue";
        public static final String BLACK = "black";
        //HomeWork
        public static final String YELLOW = "yellow";
        public static final String WHITE = "white";
        public static final String MAGENTA = "magenta";
        public static final String CYAN = "cyan";

        JButton btnRed;
        JButton btnBlack;
        JButton btnBlue;
        JButton btnGreen;
        //HomeWork
        JButton btnYellow;
        JButton btnWhite;
        JButton btnMagenta;
        JButton btnCyan;
        Map<String,Color> colors = new HashMap<>();


        public ButtonPanel() {
            //FIXME: исправить так, чтобы не приходилось дублировать указание цвета
            //initButton(btnRed, RED, Color.RED);
            //initButton(btnGreen, GREEN, Color.GREEN);
            //initButton(btnBlue, BLUE, Color.BLUE);
            //initButton(btnBlack, BLACK, Color.BLACK);
            //HomeWork
            addGeneratedButton(btnRed,RED,Color.red);
            addGeneratedButton(btnGreen,GREEN,Color.green);
            addGeneratedButton(btnBlue,BLUE,Color.blue);
            addGeneratedButton(btnBlack,BLACK,Color.black);
            addGeneratedButton(btnYellow,YELLOW,Color.yellow);
            addGeneratedButton(btnWhite,WHITE,Color.white);
            addGeneratedButton(btnMagenta,MAGENTA,Color.magenta);
            addGeneratedButton(btnCyan,CYAN,Color.cyan);
            initColorsMap();
        }

        private void initColorsMap(){
            colors.put(RED,Color.red);
            colors.put(GREEN,Color.green);
            colors.put(BLUE,Color.blue);
            colors.put(BLACK,Color.black);
            colors.put(YELLOW,Color.yellow);
            colors.put(WHITE,Color.white);
            colors.put(MAGENTA,Color.magenta);
            colors.put(CYAN,Color.cyan);

        }

        private void addGeneratedButton(JButton button,String name, Color color) {
            button = new JButton(name);
            button.setBackground(color);
            if(name.equals(BLACK) || name.equals(BLUE)) {
                button.setForeground(Color.white);
            }
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setActionCommand(name);
            button.addActionListener(this);
            add(button);
        }

        /**
         * Присваиваем кнопке свойства и создаем кнопку
         * @param button
         * @param name
         * @param color
         */
        //private  void initButton(JButton button, String name, Color color ){
            //Создаем кнопку
       //     button = new JButton();
            //Устанавливаем цвет кнопки - берем цвет, который к нам пришел
        //    button.setBackground(color);
            //Скажем кнопке, что она не прозрачна - значение true
        //    button.setOpaque(true);
            //Границы кнопки не рисуются - значение false
        //    button.setBorderPainted(false);
            //Через name прилетает сообщение о событии, что кнопка нажата
        //    button.setActionCommand(name);
            //Добавляем слушателя
        //    button.addActionListener(this);
            //После выставления всех свойств кнопки добавляем ее на панель, ну и следовательно на форму
        //    add(button);
       // }

        /**
         * actionPerfomed вместо handleEvent в Observer
         * Тоесть: //Получить событие и обработать его
         * Через ActionEvent мы можем узнать какая кнопка нажата
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //FIXME: реализовать вместо switch, Map
            /**
             * Будет возвращено значение команды,
             * которое мы устанавливали выше: button.setActionCommand(name);
             */
           /* switch (e.getActionCommand()){
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
            }*/
            color = colors.get(e.getActionCommand());
            System.out.println("You changed color.");
        }
    }

    /**
     * Данный класс будет слушать нажатие на клавишу мышки
     * Это тоже внутренний класс.Он расположен внутри PaintFrame
     */
    private class DrawListener extends MouseAdapter{
        /**
         * Событие, когда мы будем перемещать мышку
         * @param e
         */
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            /**
             * Получить координаты мышки
             */
            Point point = e.getPoint();

            if (lastPoint == null) {
                /**
                 * Та точка, на которой сейчас находится мышка является последней
                 */
                lastPoint = point;
                return;
            }
            /**
             * Если lastPoint уже есть, то текущая точка, которая пришла явялется последней, до нее
             * надо рисовать
             * Как только мы мышку отпускаем происходит событие mouseReleased и lastPoint обнуляется
             */
            //lines.add(new Line2D.Float(lastPoint, point));
            lines.add(new ColoredLine(new Line2D.Float(lastPoint,point),color));
            lastPoint = point;
            panel.repaint();
        }

        /**
         * Событие, когда мы отпускаем мышку
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            /**
             * Когда мы отпускаем мышку
             * lastPoint - точки, из которых состоит наша линия
             */
            lastPoint = null;
        }
    }

    /**
     * Конструктор PaintFrame - окно приложения PaintFrame - здесь мы определяем свойства окна
     * @param title
     * @throws HeadlessException
     */
    public PaintFrame(String title) throws HeadlessException {
        super(title);
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * Задание менеджера расположения элементов на форме
         * По умолчанию setLayout(new BorderLayout());
         * Закометируем его.Будем использовать другой
         */
        //setLayout(new BorderLayout());
        //Задаем панель, на которой будем рисовать
        panel = new DrawPanel();
        DrawListener drawListener = new DrawListener();
        /**
         * Добавляем наблюдателя для событий мыши
         */
        //Наблюдаем клики мышки
        panel.addMouseListener(drawListener);
        //Наблюдаем перемещение мышки
        panel.addMouseMotionListener(drawListener);
        //Добавляем на форму нашу отрисованную панель с кнопками и местом для рисования
        add(panel);
        /**
         * Отдельно добавляем панель с кнопками
         * Разместим панель с кнопками сверху
         */
        add(new ButtonPanel(),BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        PaintFrame paintFrame = new PaintFrame("My Super Paint");
        paintFrame.setVisible(true);
    }
}
