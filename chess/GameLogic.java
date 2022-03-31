package chess;

public class GameLogic {
    public static Field getFieldByCoordinates(Field[] fields, int x, int y) {
        return fields[((y - 1) * 8) + 8 - x];
    }

    public static boolean moveIsValid(Field origin, Field destination) {
        switch (origin.getFigure().getName()) {
            case "Pawn":
                if (origin.getFigure().getPlayer().getId() == 0) {
                    if (origin.getY() + 1 == destination.getY()) {
                        if (origin.getX() == destination.getX()) {
                            return true;
                        }
                    }
                    if (origin.getY() + 2 == destination.getY() && origin.getY() == 1) {
                        if (origin.getX() == destination.getX()) {
                            return true;
                        }
                    }
                    if (origin.getY() + 1 == destination.getY() && origin.getX() + 1 == destination.getX()) {
                        return true;
                    }
                    if (origin.getY() + 1 == destination.getY() && origin.getX() - 1 == destination.getX()) {
                        return true;
                    }
                }
                if (origin.getFigure().getPlayer().getId() == 1) {
                    if (origin.getY() - 1 == destination.getY()) {
                        if (origin.getX() == destination.getX()) {
                            return true;
                        }
                    }
                    if (origin.getY() - 2 == destination.getY() && origin.getY() == 6) {
                        if (origin.getX() == destination.getX()) {
                            return true;
                        }
                    }
                    if (origin.getY() - 1 == destination.getY() && origin.getX() + 1 == destination.getX()) {
                        return true;
                    }
                    if (origin.getY() - 1 == destination.getY() && origin.getX() - 1 == destination.getX()) {
                        return true;
                    }
                }
                break;
            case "Rook":
                if (origin.getX() == destination.getX()) {
                    return true;
                }
                if (origin.getY() == destination.getY()) {
                    return true;
                }
                break;
            case "Knight":
                if (origin.getX() + 1 == destination.getX() && origin.getY() + 2 == destination.getY()) {
                    return true;
                }
                if (origin.getX() + 2 == destination.getX() && origin.getY() + 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() - 1 == destination.getX() && origin.getY() + 2 == destination.getY()) {
                    return true;
                }
                if (origin.getX() - 2 == destination.getX() && origin.getY() + 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() + 1 == destination.getX() && origin.getY() - 2 == destination.getY()) {
                    return true;
                }
                if (origin.getX() + 2 == destination.getX() && origin.getY() - 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() - 1 == destination.getX() && origin.getY() - 2 == destination.getY()) {
                    return true;
                }
                if (origin.getX() - 2 == destination.getX() && origin.getY() - 1 == destination.getY()) {
                    return true;
                }
                break;
            case "Bishop":
                if (Math.abs(origin.getX() - destination.getX()) == Math.abs(origin.getY() - destination.getY())) {
                    return true;
                }
                break;
            case "Queen":
                if (origin.getX() == destination.getX()) {
                    return true;
                }
                if (origin.getY() == destination.getY()) {
                    return true;
                }
                if (Math.abs(origin.getX() - destination.getX()) == Math.abs(origin.getY() - destination.getY())) {
                    return true;
                }
                break;
            case "King":
                if (origin.getX() + 1 == destination.getX() && origin.getY() == destination.getY()) {
                    return true;
                }
                if (origin.getX() - 1 == destination.getX() && origin.getY() == destination.getY()) {
                    return true;
                }
                if (origin.getX() == destination.getX() && origin.getY() + 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() == destination.getX() && origin.getY() - 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() + 1 == destination.getX() && origin.getY() + 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() + 1 == destination.getX() && origin.getY() - 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() - 1 == destination.getX() && origin.getY() + 1 == destination.getY()) {
                    return true;
                }
                if (origin.getX() - 1 == destination.getX() && origin.getY() - 1 == destination.getY()) {
                    return true;
                }
                break;
        }
        return false;
    }

    public static void checkMate(Field[] fields, Player turn) {
        boolean check = false;

        Field kingField = null;
        for (Field field : fields) {
            if (field.getFigure() != null) {
                if (field.getFigure().getName().equals("King") && field.getFigure().getPlayer().equals(turn)) {
                    kingField = field;
                    break;
                }
            }
        }

        if (kingField == null) {
            System.out.println(turn.getName() + " is checkmate!");
            System.exit(0);
        }

        for (Field field : fields) {
            if (field.getFigure() == null || field.getFigure().getPlayer().equals(turn)) {
                continue;
            }
            if (moveIsValid(field, kingField)) {
                check = true;
            }
        }
        for (Field field : fields) {
            if (field.getFigure() == null || field.getFigure().getPlayer().equals(turn)) {
                continue;
            }
            if (moveIsValid(kingField, field)) {
                for (Field field2 : fields) {
                    if (!(moveIsValid(field2, field))) {
                        return;
                    }
                    System.out.println(turn.getName() + " is checkmate!");
                    System.exit(0);
                }
            }
        }
        if (check) {
            System.out.println(turn.getName() + " is check!");
        }
    }
}
