package ex3;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */

/**
 * Интерфейс Наблюдаемый
 * Это интерфейс реализуют те класса, которые нужно наблюдать
 */
public interface IObservable {
    //Уведомить наблюдателей о событии
    void notifyObservers();
    //Добавить наблюдателя, тип наблюдателя IObserver
    void addObserver(IObserver observer);
    void remoteObserver(IObserver observer);
}
