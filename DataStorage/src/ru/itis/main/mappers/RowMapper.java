package ru.itis.main.mappers;

/**
 * 27.04.2017
 * RowMapper
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

/**
 * Интерфейс, описывающий функцию, которая отображает строку
 * в объект
 * @param <T>
 */
public interface RowMapper<T> {
    T mapRow(String row);
}
