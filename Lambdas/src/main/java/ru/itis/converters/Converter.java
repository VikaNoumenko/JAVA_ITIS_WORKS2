package ru.itis.converters;

import java.util.function.Function;

/**
 * Задача:
 * сконвертировать объект типа T в объект типа
 * V по определенному правилу-функции
 *
 * Function
 */
public class Converter {
    public static <T,V> V convert(T input, Function<T,V> function) {
        return function.apply(input);
    }
}
