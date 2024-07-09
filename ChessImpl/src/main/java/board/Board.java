package board;

import pieces.*;
import resources.Color;

import java.io.PipedReader;

public class Board {
    static Piece[][] mainBoard = new Piece[8][8];
    public Piece[][] createNewBoard() {
        mainBoard[0][0] = new Rook().setColor(Color.BLACK);
        mainBoard[0][1] = new Knight().setColor(Color.BLACK);
        mainBoard[0][2] = new Bishop().setColor(Color.BLACK);
        mainBoard[0][3] = new Queen().setColor(Color.BLACK);
        mainBoard[0][4] = new King().setColor(Color.BLACK);
        mainBoard[0][5] = new Bishop().setColor(Color.BLACK);
        mainBoard[0][6] = new Knight().setColor(Color.BLACK);
        mainBoard[0][7] = new Rook().setColor(Color.BLACK);

        mainBoard[7][0] = new Rook().setColor(Color.WHITE);
        mainBoard[7][1] = new Knight().setColor(Color.WHITE);
        mainBoard[7][2] = new Bishop().setColor(Color.WHITE);
        mainBoard[7][3] = new Queen().setColor(Color.WHITE);
        mainBoard[7][4] = new King().setColor(Color.WHITE);
        mainBoard[7][5] = new Bishop().setColor(Color.WHITE);
        mainBoard[7][6] = new Knight().setColor(Color.WHITE);
        mainBoard[7][7] = new Rook().setColor(Color.WHITE);
        for(int i=0;i<8;i++) {
             mainBoard[1][i] = new Pawn().setColor(Color.BLACK);
             mainBoard[6][i] = new Pawn().setColor(Color.WHITE);
        }
        return mainBoard;
    }
}
