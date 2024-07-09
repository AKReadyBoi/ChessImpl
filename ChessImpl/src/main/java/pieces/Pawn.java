package pieces;

import resources.Color;

public class Pawn implements Piece {
    private Color color;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Pawn setColor(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public boolean isValidMove(int x, int y, int newX, int newY, Piece[][] board) {
        int direction = (color == Color.WHITE) ? -1 : 1;
        int startRow = (color == Color.WHITE) ? 6 : 1;

        // Взятие на проходе
        if (Math.abs(newY - y) == 1 && board[x][newY] == null) {
            if (board[x][y] instanceof Pawn enemyPawn && board[x][y].getColor() != color) {
                if (enemyPawn.isEnPassantMove(x, y, newX, newY)) {
                    return true;
                }
            }
        }

        // Шаг вперед на одну клетку
        if (newX == x + direction && newY == y && board[newX][newY] == null) {
            return true;
        }

        // Шаг вперед на две клетки с начальной позиции
        if (x == startRow && newX == x + 2 * direction && newY == y && board[newX][newY] == null && board[x + direction][y] == null) {
            return true;
        }

        // Битье по диагонали
        if (Math.abs(newY - y) == 1 && board[newX][newY] != null && board[newX][newY].getColor() != color) {
            return true;
        }

        return false;
    }

    @Override
    public char getSymbol() {
        return (color == Color.WHITE) ? '♙' : '♟';
    }

    private boolean isEnPassantMove(int x, int y, int newX, int newY) {
        return Math.abs(newY - y) == 1 && Math.abs(newX - x) == 1;
    }
}
