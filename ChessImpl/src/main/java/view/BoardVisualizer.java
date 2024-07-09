package view;

import controller.BoardController;
import pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardVisualizer {
    private JFrame frame;
    private ChessBoardPanel boardPanel;

    public void visualize(Piece[][] board) {
        if (frame == null) {
            createAndShowGUI(board);
        } else {
            boardPanel.updateBoard(board);
        }
    }

    private void createAndShowGUI(Piece[][] board) {
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        boardPanel = new ChessBoardPanel(board);
        frame.add(boardPanel);
        frame.setVisible(true);
    }
}

class ChessBoardPanel extends JPanel {
    private int startX, startY;
    private int currentX, currentY;
    private Piece draggedPiece = null;
    private Piece[][] board;
    private static final int TILE_SIZE = 64;
    private static final int BOARD_SIZE = TILE_SIZE * 8;

    public ChessBoardPanel(Piece[][] board) {
        this.board = board;
        this.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / TILE_SIZE;
                int row = e.getY() / TILE_SIZE;
                handleMousePressed(row, col);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int col = e.getX() / TILE_SIZE;
                int row = e.getY() / TILE_SIZE;
                handleMouseReleased(row, col);
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                currentX = Math.max(0, Math.min(currentX, BOARD_SIZE));
                currentY = Math.max(0, Math.min(currentY, BOARD_SIZE));
                repaint();
            }
        });
    }

    public void updateBoard(Piece[][] board) {
        this.board = board;
        repaint();
    }

    private void handleMousePressed(int x, int y) {
        if (board[x][y] != null) {
            startX = x;
            startY = y;
            draggedPiece = board[x][y];
        }
    }

    private void handleMouseReleased(int x, int y) {
        if (draggedPiece != null) {
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                new BoardController(startX, startY, x, y);
            }
            draggedPiece = null;
            updateBoard(BoardController.mainBoard);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean isWhite = (row + col) % 2 == 0;
                g.setColor(isWhite ? Color.WHITE : Color.GRAY);
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                Piece piece = board[row][col];
                if (piece != null && piece != draggedPiece) {
                    if (piece.getColor().equals(resources.Color.WHITE)) {
                        g.setColor(Color.LIGHT_GRAY);
                    } else {
                        g.setColor(Color.DARK_GRAY);
                    }
                    g.drawString(String.valueOf(piece.getSymbol()), col * TILE_SIZE + TILE_SIZE / 2, row * TILE_SIZE + TILE_SIZE / 2);
                }
            }
        }
        if (draggedPiece != null) {
            g.setColor(draggedPiece.getColor().equals(resources.Color.WHITE) ? Color.LIGHT_GRAY : Color.DARK_GRAY);
            g.drawString(String.valueOf(draggedPiece.getSymbol()), currentX - TILE_SIZE / 2, currentY - TILE_SIZE / 2);
        }
    }
}
