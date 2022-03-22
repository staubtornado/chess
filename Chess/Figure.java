package Chess;

public class Figure {
    private final String name;
    private final String symbol;
    private final Player player;
    private int x;
    private int y;

    public Figure(String name, String symbol, Player player) {
        this.name = name;
        this.symbol = symbol;
        this.player = player;
    }

    public String getName() {return name;}
    public String getSymbol() {return symbol;}
    public Player getPlayer() {return player;}
}
