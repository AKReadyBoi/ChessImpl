package pieces;

import resources.Color;

public class Queen implements Piece {
    Color color;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Queen setColor(Color color) {
        this.color = color;
        return this;
    }
    @Override
    public boolean isValidMove(int x, int y, int newX, int newY, Piece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);
        if (dx == dy || x == newX || y == newY) {
            int deltaX = (newX - x) == 0 ? 0 : (newX - x) / Math.abs(newX - x);
            int deltaY = (newY - y) == 0 ? 0 : (newY - y) / Math.abs(newY - y);
            for (int i = 1; i < Math.max(dx, dy); i++) {
                if (board[x + i * deltaX][y + i * deltaY] != null) {
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
            return '♕';
        } else {
            return '♛';
        }
    }
}
