package chess;

public class GUI {
    public void sendGui(Player[] players, Field[] fields) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        System.out.println("♟ : " + players[1].getName());
        System.out.println("♙ : " + players[0].getName());
        System.out.println();
        System.out.print("8 ");

        for (int i = fields.length; i > 0; i--) {
            String symbol = "";

            try {symbol = fields[i - 1].getFigure().getSymbol() + "   ";} catch (NullPointerException e) {
                if (((i - 1) / 8) % 2 == 0) {
                    if ((i - 1) % 2 == 0) {System.out.print("⬛    ");}
                    else {System.out.print("⬜    ");}
                }

                else if ((i - 1) % 2 == 0) {System.out.print("⬜    ");}
                else {System.out.print("⬛    ");}
            }

            if ((i - 1) % 8 == 0) {
                symbol += "\n";
                if ((i - 1) / 8 != 0) {
                    symbol += (i - 1) / 8 + " ";
                }
            }
            System.out.print(symbol);
        }
        System.out.print("  ");
        for (int i = 1; i < 9; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        System.out.println();
    }
}
