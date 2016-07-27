package ex3;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer(3);
        timer.addObserver(new MyObserver());
        timer.addObserver(new IObserver() {
            @Override
            public void handleEvent() {
                System.out.println("Observer#2");
            }
        });
        System.out.println("Timer running...");
        timer.star();
    }
}
