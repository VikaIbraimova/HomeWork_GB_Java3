package ex3;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */
public class MyObserver implements IObserver {
    @Override
    public void handleEvent() {
        System.out.println("Таймер сработал!");
    }
}
