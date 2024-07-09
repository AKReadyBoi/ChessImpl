package pieces;

import resources.Color;

public interface Piece {
    Color getColor();
    Piece setColor(Color color);
    default Piece[][] move(int x, int y, int newX, int newY, Piece[][] board) {
        if(isValidMove(x, y, newX, newY, board)) {
            board[newX][newY] = board[x][y];
            board[x][y] = null;
            return board;
        } else {
            return null;
        }
    }
    boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board);
    char getSymbol();
}
