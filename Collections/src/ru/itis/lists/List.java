package ru.itis.lists;

/**
 * 20.04.2017
 * List
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

/**
 * Коллекция типа Список
 * - Найти
 * - Добавить
 * - Удалить
 * - Получить по номеру
 */
public interface List<T> extends Iterable<T> {
    /**
     * Добавление элемента в конец списка
     * @param element добавляемый элемент
     */
    void add(T element);

    /**
     * Удаление по элементу
     * @param element элемент, который необходимо удалить
     */
    void delete(T element);

    /**
     * Удалить по индексу
     * @param index
     */
    void removeByIndex(int index);

    /**
     * Получить по индексу
     * @param index
     * @return
     */
    T get(int index);

    /**
     * Получить индекс элемента
     * @param element
     * @return
     */
    int indexOf(T element);

    void addToBegin(T element);

    int size();
}
