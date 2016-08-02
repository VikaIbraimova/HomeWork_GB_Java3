package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladislav Gasanov on 21.07.2016.
 */

/**
 * Данный класс реализует интерфейс Наблюдаемый
 * Timer будет генерировать сообщения
 *
 */
public class Timer implements IObservable {
    //Время задержки(остановки) таймера
    private int delay;
    //Наблюдателей может быть несколько(больше одного), поэтому заводим для них список
    private List<IObserver> observers = new ArrayList<>();

    public Timer(int delay) {
        this.delay = delay;
    }

    //Уведомить наблюдателей
    @Override
    public void notifyObservers() {
        /**
         * Идем по коллекции observers типа IObserver
         */
        for (IObserver observer :
                observers) {
            /**
             * Берем каждого наблюдателя из коллекции и
             * вызываем у него метод handleEvent() -
             * тоесть все наблюдатели, которые подписались на события класса Timer(элменты коллекции observers) будут уведомленены
             * о каком то событии(смотри метод start)
             */
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

    /**
     * Запускаем таймер и говорим об этом
     */
    void star(){
        try {
            /**
             * Есть пакет TimeUnit, в котором есть задержки
             * Берем задержку в секундах,указываем в скобках кол-во секунд-задержку(delay) и засыпаем
             */
            TimeUnit.SECONDS.sleep(delay);
            //Уведомить наблюдателей о событии(что произошла задержка) - реализация notifyObservers выше - здесь просто вызываем этот метод
            notifyObservers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
