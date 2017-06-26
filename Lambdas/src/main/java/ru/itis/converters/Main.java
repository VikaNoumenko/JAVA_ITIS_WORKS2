package ru.itis.converters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String hello = "Hello";

        /**
        int asInt = Converter.convert(hello,
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.hashCode();
                    }
                });
        **/

        /**
        int asInt = Converter.convert(hello,
                input -> {
                        return input.hashCode();
                });
         **/

        int asInt = Converter.convert(hello,
                input -> input.hashCode());

    }
}
