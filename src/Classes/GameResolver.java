package Classes;

public class GameResolver {
    /**
     * Function to check if there are three similar pieces on the same line
     * 
     * @param board
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean areThreePiecesInLine(int[][] board, int row, int col) {
        int gamePiece = board[row][col];

        if (gamePiece == 0) return false;

        // down check
        boolean isCellOutOfBoard = (row+1>board.length-1 || row+2>board.length-1);
        if(!isCellOutOfBoard && board[row+1][col] == gamePiece && board[row+2][col] == gamePiece) {
            return true;
        }

        // up check
        isCellOutOfBoard = (row-1 < 0);
        if (!isCellOutOfBoard && board[row-1][col] == gamePiece) {
            isCellOutOfBoard = (row-2 < 0);
            if (!isCellOutOfBoard && (board[row-2][col] == gamePiece)) {
                return true;
            }
        }

        // down left check
        isCellOutOfBoard = (row+1>board.length-1 || row+2>board.length-1 || col-1 < 0 || col-2 < 0);
        if(!isCellOutOfBoard && board[row+1][col-1] == gamePiece && board[row+2][col-2] == gamePiece) {
            return true;
        }

        // up right check
        isCellOutOfBoard = (row-1 < 0 || col+1>board.length-1 || col+2>board.length-1);
        if (!isCellOutOfBoard && board[row-1][col+1] == gamePiece) {
            isCellOutOfBoard = (row-2 < 0 || col+2>board.length-1);
            if (!isCellOutOfBoard && (board[row-2][col+2] == gamePiece)) {
                return true;
            }
        }

        // down right check
        isCellOutOfBoard = (row+1>board.length-1 || row+2>board.length-1 || col+1>board.length-1 || col+2>board.length-1);
        if(!isCellOutOfBoard && board[row+1][col+1] == gamePiece && board[row+2][col+2] == gamePiece) {
            return true;
        }

        // up left check
        isCellOutOfBoard = (row-1 < 0 || col-1 < 0 || col-2 < 0);
        if (!isCellOutOfBoard && board[row-1][col-1] == gamePiece) {
            isCellOutOfBoard = (row-2 < 0 || col-2 < 0);
            if (!isCellOutOfBoard && (board[row-2][col-2] == gamePiece)) {
                return true;
            }
        }

        // right check
        isCellOutOfBoard = (col+1>board.length-1 || col+2>board.length-1);
        if(!isCellOutOfBoard && board[row][col+1] == gamePiece && board[row][col+2] == gamePiece) {
            return true;
        }

        // left check
        isCellOutOfBoard = (col-1 < 0);
        if (!isCellOutOfBoard && board[row][col-1] == gamePiece) {
            isCellOutOfBoard = (col-2 < 0);
            if (!isCellOutOfBoard && (board[row][col-2] == gamePiece)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Function to resolve the game
     * 
     * @param board
     * @return GameState
     */
    public static GameState resolve(int[][] board) {
        // for every cell in the board
        // check if 3 consecutive cells are in line
        for(int row=0; row<3; row++) {
            for(int col=0; col<3; col++) {
                boolean isThreePiecesInLine = areThreePiecesInLine(board, row, col);
                if (isThreePiecesInLine) {
                    if(board[row][col] == 1) {
                        return GameState.X_WON;
                    } else {
                        return GameState.O_WON;
                    }
                } 
            }
        }
        return GameState.IN_PROGRESS;
    }

    /**
     * Enum to represent the game state
     */
    public enum GameState{IN_PROGRESS, X_WON, O_WON, DRAW;}

    /**
     * Function to print the game menu
     */
    public static void displayGameMenu() {
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        System.out.println("3. Computer vs Computer");
    }
}