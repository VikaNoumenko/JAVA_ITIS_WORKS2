package ru.itis.interfaces;

import ru.itis.Artist;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class Main {
    public static void main(String[] args) {

       // Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R
        Function<Artist, Artist> replace = artist -> new Artist(artist.getName(), artist.getFrom());
        Artist ricky = new Artist("Puerto  Ricko", "Ricky Martin");
        Artist newRicky = replace.apply(ricky);


//        Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
//                Если оно соблюдается, то возвращается значение true.
//                В качестве параметра лямбда-выражение принимает объект типа T
        Predicate<Artist> from = artist -> artist.isFrom("British");
        System.out.println(from.test(ricky));

        //Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая
        Consumer<Artist> printer = artist -> System.out.println(artist.getFrom());
        printer.accept(ricky);
    }
}
