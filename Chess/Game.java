package Chess;

import java.util.Scanner;

public class Game {
    private final Player[] players = new Player[2];
    private final Field[] fields = new Field[64];
    private Player turn;
    private final GUI gui;

    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Please enter the name of player " + (i + 1) + ".");
            players[i] = new Player(scanner.nextLine(), i);
        }
        turn = players[0];
        gui = new GUI();

        int x = 0;
        for (int i = 0; i < fields.length; i++) {
            Figure figure = null;
            int y = (int) Math.floor(i / 8.0);

            if (y == 1) {figure = new Figure("Pawn", "♙", players[0]);}
            if (y == 6) {figure = new Figure("Pawn", "♟", players[1]);}
            if ((x == 1 && y == 0) || x == 6 && y == 0) {figure = new Figure("Knight", "♘", players[0]);}
            if ((x == 1 && y == 7) || x == 6 && y == 7) {figure = new Figure("Knight", "♞", players[1]);}
            if ((x == 0 && y == 0) || x == 7 && y == 0) {figure = new Figure("Rook", "♖", players[0]);}
            if ((x == 0 && y == 7) || x == 7 && y == 7) {figure = new Figure("Rook", "♜", players[1]);}
            if ((x == 2 && y == 0) || x == 5 && y == 0) {figure = new Figure("Bishop", "♗", players[0]);}
            if ((x == 2 && y == 7) || x == 5 && y == 7) {figure = new Figure("Bishop", "♝", players[1]);}
            if (x == 3 && y == 0) {figure = new Figure("Queen", "♕", players[0]);}
            if (x == 3 && y == 7) {figure = new Figure("Queen", "♛", players[1]);}
            if (x == 4 && y == 0) {figure = new Figure("King", "♔", players[0]);}
            if (x == 4 && y == 7) {figure = new Figure("King", "♚", players[1]);}

            fields[i] = new Field(figure, x, y);
            x += 1;
            if (x > 7) {x = 0;}
        }
    }

    private Field getField(int x, int y) {
        return fields[((y - 1) * 8) + 8 - x];
    }

    private void nextTurn() {
        Field originField = null;
        Field destinationField = null;

        System.out.println(turn.getName() + ": Please enter your move! (x, y to x, y)");
        String[] input = new String[4];

        while (destinationField == null) {
            try {
                int index = 0;
                for (String coordinate : scanner.nextLine().split(" to ")) {
                    for (String x: coordinate.split(", ")) {
                        input[index] = x;
                        index++;
                    }
                }
                originField = getField(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                destinationField = getField(Integer.parseInt(input[2]), Integer.parseInt(input[3]));

                boolean invalid = originField.getFigure().getPlayer() != turn;
                if (originField == destinationField) {invalid = true;}

                if (invalid) {
                    System.out.println("Invalid turn! Try again!");
                    destinationField = null;
                }

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Invalid Field! Try again!");
                destinationField = null;
            }
        }
        destinationField.setFigure(originField.getFigure());
        originField.setFigure(null);
    }

    public void run() {
        gui.sendGui(players, fields);

        while (true) {
            nextTurn();
            if (turn == players[0]) {turn = players[1];} else {turn = players[0];}
            gui.sendGui(players, fields);
        }
    }
}
