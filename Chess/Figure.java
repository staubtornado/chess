package chess;

import java.util.Objects;
import java.util.Scanner;

public class Figure {
    private String name;
    private String symbol;
    private final Player player;

    public Figure(String name, String symbol, Player player) {
        this.name = name;
        this.symbol = symbol;
        this.player = player;
    }

    public void onMove(Field destination) {
        if (Objects.equals(name, "Pawn")) {
            Scanner scanner = new Scanner(System.in);
            String input;

            if (destination.getY() == 7) {
                System.out.println(player.getName() + ": Please enter the figure in which you want to transform your " +
                        "Pawn.");
                input = scanner.nextLine();

                switch (input) {
                    case "Knight":
                        name = "Knight";
                        symbol = "♘";
                        break;
                    case "Rook":
                        name = "Rook";
                        symbol = "♖";
                        break;
                    case "Bishop":
                        name = "Bishop";
                        symbol = "♗";
                        break;
                    case "Queen":
                        name = "Queen";
                        symbol = "♕";
                        break;
                    default:
                        System.out.println("Invalid figure.");
                        onMove(destination);
                }
            }
            else if (destination.getY() == 0) {
                System.out.println(player.getName() + ": Please enter the figure in which you want to transform your " +
                        "Pawn.");
                input = scanner.nextLine();

                switch (input) {
                    case "Knight":
                        name = "Knight";
                        symbol = "♞";
                        break;
                    case "Rook":
                        name = "Rook";
                        symbol = "♜";
                        break;
                    case "Bishop":
                        name = "Bishop";
                        symbol = "♝";
                        break;
                    case "Queen":
                        name = "Queen";
                        symbol = "♛";
                        break;
                    default:
                        System.out.println("Invalid figure.");
                        onMove(destination);
                }
            }
        }
    }

    public String getName() {return name;}
    public String getSymbol() {return symbol;}
    public Player getPlayer() {return player;}
}
