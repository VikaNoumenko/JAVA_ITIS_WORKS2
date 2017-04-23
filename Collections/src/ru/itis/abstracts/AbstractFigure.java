package ru.itis.abstracts;


public abstract class AbstractFigure implements Figure {
    public boolean equals(Object object) {
        if (object != null && object instanceof Figure) {
            Figure that = (Figure)object;
            return this.area() == that.area();
        } else return false;
    }
}
