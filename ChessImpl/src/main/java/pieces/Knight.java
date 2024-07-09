package pieces;

import resources.Color;

public class Knight implements Piece {
    Color color;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Knight setColor(Color color) {
        this.color = color;
        return this;
    }
    @Override
    public boolean isValidMove(int x, int y, int newX, int newY, Piece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            Piece destinationPiece = board[newX][newY];
            return destinationPiece == null || destinationPiece.getColor() != this.getColor();
        }

        return false;
    }

    @Override
    public char getSymbol() {
        if(color.equals(Color.WHITE)) {
            return '♘';
        } else {
            return '♞';
        }
    }
}
