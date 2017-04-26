package ru.itis.observer.obideal;

import java.util.ArrayList;
import java.util.List;

/**
 * 25.04.2017
 * AbstractObservable
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class AbstractObservable implements Observable {

    private List<Observer> observers;

    public AbstractObservable() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver(Object... args) {
        for (Observer observer : observers) {
            observer.handle(args);
        }
    }
}
