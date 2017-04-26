package ru.itis.observer.obideal;

/**
 * 25.04.2017
 * Observable
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface Observable {
    /**
     * Добавление наблюдателя
     * @param observer
     */
    void addObserver(Observer observer);
    void notifyObserver(Object ... args);
}
