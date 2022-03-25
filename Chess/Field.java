package Chess;

public class Field {
    private Figure figure;
    private final int y;

    public Field(Figure figure, int y) {
        this.figure = figure;
        this.y = y;
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
