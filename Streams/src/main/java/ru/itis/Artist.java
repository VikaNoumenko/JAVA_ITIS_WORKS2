package ru.itis;

public class Artist {
    private String from;
    private String name;

    public Artist(String from, String name) {
        this.from = from;
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public String getName() {
        return name;
    }

    public boolean isFrom(String country) {
        return from.equals(country);
    }
}
