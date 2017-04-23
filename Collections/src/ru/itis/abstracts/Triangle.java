package ru.itis.abstracts;

public class Triangle extends AbstractFigure {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public int area() {
        int p = (a + b + c) / 2;
        return (int)Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

