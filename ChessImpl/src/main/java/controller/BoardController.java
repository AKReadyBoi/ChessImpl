package controller;

import board.Board;
import pieces.Piece;
import resources.Color;
import view.BoardVisualizer;

public class BoardController {
    public static Piece[][] mainBoard = new Board().createNewBoard();
    private static Color turn = Color.WHITE;
    private static BoardVisualizer boardVisualizer = new BoardVisualizer();

    public BoardController() {
        boardVisualizer.visualize(mainBoard);
    }
    public BoardController(int x, int y, int newX, int newY) {
        if (mainBoard[x][y] != null && (newX != x || newY != y)) {
            if (mainBoard[x][y].getColor().equals(turn)) {
                Piece[][] newBoard = mainBoard[x][y].move(x, y, newX, newY, mainBoard);
                if (newBoard != null) {
                    mainBoard = newBoard;
                    turn = (turn == Color.WHITE) ? Color.BLACK : Color.WHITE;
                    boardVisualizer.visualize(mainBoard);
                }
            }
        }
    }
}
