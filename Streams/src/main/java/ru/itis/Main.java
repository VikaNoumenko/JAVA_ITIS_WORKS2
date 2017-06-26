package ru.itis;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(final String[] args) {
        List<Artist> artists = Arrays.asList(
                new Artist("British", "Ricky Martin"),
                new Artist("Germany", "Til Linderman"),
                new Artist("Russia", "Gagarina"),
                new Artist("British", "Placebo"),
                new Artist("British", "Beatles"),
                new Artist("Russia", "Shnur"),
                new Artist("British", "Depeche Mode"),
                new Artist("Russia", "Ranetki"));


        long count = artists.stream()
                .filter(artist -> {
                    boolean result = artist.isFrom("British");
                    System.out.println("Hello");
                    return result;
                }).count();

        /*
        for (Artist artist : artists) {
            if (artist.isFrom("British")) {
                count++;
            }
        }

        Iterator<Artist> iterator = artists.iterator();
        while (iterator.hasNext()) {
            Artist currentArtist = iterator.next();
            if (currentArtist.isFrom("British")) {
                count++;
            }
        }
        */



    }
}
