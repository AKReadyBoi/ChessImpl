package pieces;

import resources.Color;

public class Bishop implements Piece {
    Color color;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Bishop setColor(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public boolean isValidMove(int x, int y, int newX, int newY, Piece[][] board) {
        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            int deltaX = (newX - x) > 0 ? 1 : -1;
            int deltaY = (newY - y) > 0 ? 1 : -1;
            int steps = Math.abs(newX - x);
            for (int i = 1; i < steps; i++) {
                int currentX = x + i * deltaX;
                int currentY = y + i * deltaY;
                if (board[currentX][currentY] != null) {
                    return false;
                }
            }
            Piece destinationPiece = board[newX][newY];
            return destinationPiece == null || destinationPiece.getColor() != this.getColor();
        }
        return false;
    }

    @Override
    public char getSymbol() {
        if(color.equals(Color.WHITE)) {
            return '♗';
        } else {
            return '♝';
        }
    }
}
