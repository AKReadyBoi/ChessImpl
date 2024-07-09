package pieces;

import resources.Color;

public class King implements Piece {
    private Color color;
    private Color s;
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public King setColor(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public boolean isValidMove(int x, int y, int newX, int newY, Piece[][] board) {
        return false;
    }

    @Override
    public char getSymbol() {
        if(color.equals(Color.WHITE)) {
            return '♔';
        } else {
            return '♚';
        }
    }
}
