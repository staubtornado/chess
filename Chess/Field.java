package Chess;

public class Field {
    private Figure figure;
    private int x;
    private int y;

    public Field(Figure figure, int x, int y) {
        this.figure = figure;
        this.x = x;
        this.y = y;
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
