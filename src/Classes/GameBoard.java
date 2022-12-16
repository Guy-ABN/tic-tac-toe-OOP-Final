package Classes;

import java.util.Random;

/**
 * This class is used to create a game board for the tic tac toe game.
 * 
 * @author Guy ABN
 * @version 1.0
 * 
 */
public class GameBoard {
    private int[][] board = new int[3][3];
    private String rowSeparator = "---+---+---";

    /**
     * Function to print the board instructions
     * 
     * @return void
     */
    public void instructionBoard() {
        System.out.println(" 1 | 2 | 3 ");
        System.out.println(rowSeparator);
        System.out.println(" 4 | 5 | 6 ");
        System.out.println(rowSeparator);
        System.out.println(" 7 | 8 | 9 ");
    }

    /**
     * Function to print the progress of the board
     * 
     * @return void
     */
    public void displayBoard() {
        System.out.println(printRow(0));
        System.out.println(rowSeparator);
        System.out.println(printRow(1));
        System.out.println(rowSeparator);
        System.out.println(printRow(2));
    }

    /**
     * Function to print a row of the board
     * 
     * @param rowNumber
     * @return String
     */
    private String printRow(int rowNumber) {
        StringBuilder rowToDisplay = new StringBuilder(" ");
        for (int i = 0; i < 3; i++) {
            if(board[rowNumber][i] == 0) rowToDisplay.append(" ");
            if(board[rowNumber][i] == 1) rowToDisplay.append("X");
            if(board[rowNumber][i] == 2) rowToDisplay.append("O");
            rowToDisplay.append(" | ");
        }
        rowToDisplay.deleteCharAt(rowToDisplay.lastIndexOf(" "));
        return rowToDisplay.toString();
    }

    /**
     * Function to check if the cell is empty
     * and place the piece of the user in the cell.
     * - 0 is empty
     * - 1 is X
     * - 2 is O
     * 
     * @param position
     * @param pieceType
     * @return
     */
    public boolean placePiece(int position, String pieceType) {
        // row and col based on position
        int row = (position-1)/3;
        int col = (position-(row*3))-1;
        
        // check if the cell is empty then place the piece
        if(board[row][col] == 0) {
            if(pieceType.equals("X")) board[row][col] = 1;
            if(pieceType.equals("O")) board[row][col] = 2;
            return true;
        }
        // if the cell is not empty ask the user to choose another cell
        return false;
    }

    /**
     * Function to check if the cell is empty
     * and place the piece of the computer in the cell.
     * - 0 is empty
     * - 1 is X
     * - 2 is O
     * 
     * @param pieceType
     * @return
     */
    public boolean placePieceRandomly(String pieceType) {
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        boolean wasPiecePlaced = false;

        while(!wasPiecePlaced && !isMatrixFull()) {
            if(board[row][col] == 0) {
                if(pieceType.equals("X")) board[row][col] = 1;
                if(pieceType.equals("O")) board[row][col] = 2;
                return true;
            } else {
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
        }
        return wasPiecePlaced;
    }

    /**
     * Function to check if the board is full
     * 
     * @return boolean
     */
    public boolean isMatrixFull() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                if(board[row][col] == 0) return false;
            }
        }
        return true;
    }

    /**
     * Function to get the board matrix
     * @return int[][]
     */
    public int[][] getBoard() {
        return board;
    }
}
