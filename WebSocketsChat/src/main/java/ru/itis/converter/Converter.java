package ru.itis.converter;


import java.util.function.Function;

public class Converter {
    public static <T,V> V convert(T input, Function<T, V> function) {
        return function.apply(input);
    }
}
