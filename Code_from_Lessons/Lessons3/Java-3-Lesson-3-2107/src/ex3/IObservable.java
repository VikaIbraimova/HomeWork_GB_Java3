package ex3;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */
public interface IObservable {
    void notifyObservers();
    void addObserver(IObserver observer);
    void remoteObserver(IObserver observer);
}
