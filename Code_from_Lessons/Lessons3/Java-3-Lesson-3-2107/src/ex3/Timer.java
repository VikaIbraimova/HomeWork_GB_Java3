package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */
public class Timer implements IObservable {
    private int delay;
    private List<IObserver> observers = new ArrayList<>();

    public Timer(int delay) {
        this.delay = delay;
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer :
                observers) {
            observer.handleEvent();
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remoteObserver(IObserver observer) {
        observers.remove(observer);
    }

    void star(){
        try {
            TimeUnit.SECONDS.sleep(delay);
            notifyObservers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
