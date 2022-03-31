package chess;

public class Field {
    private Figure figure;
    private final int x;
    private final int y;

    public Field(Figure figure, int x, int y) {
        this.figure = figure;
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {return figure.getName();}
}
