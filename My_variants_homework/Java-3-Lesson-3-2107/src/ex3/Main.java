package ex3;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Создаем объект таймер и передаем в
         * конструкторе время задержки - 3 сек
         */
        Timer timer = new Timer(3);
        //Добавляем наблюдателя для таймера
        timer.addObserver(new MyObserver());
        /**
         * Пример анонимного класса
         */
        timer.addObserver(new IObserver() {
            @Override
            public void handleEvent() {
                System.out.println("Observer#2");
            }
        });
        System.out.println("Timer running...");
        //Запускаем таймер
        timer.star();
    }
}
