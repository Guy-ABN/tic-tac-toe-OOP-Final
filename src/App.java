import java.util.Scanner;
import Classes.GameBoard;
import Classes.GameResolver;

public class App {
    private static final String enterInEmptySpot = "Please enter an empty position to place your piece: ";
    private static final String enterPositionPhrase = "Please enter a position to place your piece: ";
    private static final String OWin = "O wins!";
    private static final String XWin = "X wins!";
    private static final String drawMessage = "It's a draw!";

    public static void main(String[] args) throws Exception {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);
        // Create a game board object
        GameBoard gameBoard = new GameBoard();

        // Display the game options
        GameResolver.displayGameMenu();

        // Get the user choice
        int userChoice = scanner.nextInt();

        // If the user chose to play against another player
        if (userChoice == 1) {
            // Print the instruction board
            gameBoard.instructionBoard();

            // Let the user place an X
            System.out.println(enterPositionPhrase);

            // Get the user input
            int position = scanner.nextInt();

            // Place the piece in the board
            gameBoard.placePiece(position, "X");

            // Set the game status to in progress
            boolean isGameInProgress = true;

            // While the game is in progress and the board is not full
            while (isGameInProgress && !gameBoard.isMatrixFull()) {
                // Let the user place an O and then display the board again
                System.out.println(enterPositionPhrase);
                // if the cell is not empty ask the user to choose another cell
                while (!gameBoard.placePiece(position, "O")) {
                    gameBoard.displayBoard();
                    System.out.println(enterInEmptySpot);
                    position = scanner.nextInt();
                }
                // Place the piece in the board
                gameBoard.placePiece(position, "O");
                // Display the board
                gameBoard.displayBoard();

                // set game status to in progress
                isGameInProgress = GameResolver.resolve(gameBoard.getBoard()) == GameResolver.GameState.IN_PROGRESS;

                // if game is in progress let the user place an X
                if (isGameInProgress) {
                    System.out.println(enterPositionPhrase);
                    // if the cell is not empty ask the user to choose another cell
                    while (!gameBoard.placePiece(position, "X")) {
                        gameBoard.displayBoard();
                        System.out.println(enterInEmptySpot);
                        position = scanner.nextInt();
                    }
                    gameBoard.placePiece(position, "X");

                    // set game status to in progress
                    isGameInProgress = GameResolver.resolve(gameBoard.getBoard()) == GameResolver.GameState.IN_PROGRESS;

                }
            }

            // display the board one last time
            gameBoard.displayBoard();

            // get the board results to check the winning conditions
            GameResolver.GameState gameState = GameResolver.resolve(gameBoard.getBoard());

            // print the results
            if (gameState == GameResolver.GameState.DRAW) {
                System.out.println(drawMessage);
            } else if (gameState == GameResolver.GameState.X_WON) {
                System.out.println(XWin);
            } else if (gameState == GameResolver.GameState.O_WON) {
                System.out.println(OWin);
            }
        }
        // If the user chose to play against the computer
        if (userChoice == 2) {
            // Print the instruction board
            gameBoard.instructionBoard();
    
            // Let the user place an X
            System.out.println(enterPositionPhrase);
    
            int position = scanner.nextInt();
    
            gameBoard.placePiece(position, "X");
    
            
            boolean isGameInProgress = true;
            
            while (isGameInProgress && !gameBoard.isMatrixFull()) {
                // Let the computer place an O and then display the board again
                gameBoard.placePieceRandomly("O");
                gameBoard.displayBoard();
    
                // set game status to in progress
                isGameInProgress = GameResolver.resolve(gameBoard.getBoard()) == GameResolver.GameState.IN_PROGRESS;
    
                // if game is in progress let the user place an X
                if (isGameInProgress) {
                    System.out.println(enterPositionPhrase);
                    // if the cell is not empty ask the user to choose another cell
                    while (!gameBoard.placePiece(position, "X")) {
                        
                        gameBoard.displayBoard();
                        System.out.println(enterInEmptySpot);
                        position = scanner.nextInt();
                    }
                    gameBoard.placePiece(position, "X");
                }
            }
    
            // display the board one last time
            gameBoard.displayBoard();
    
            // get the board results to check the winning conditions
            GameResolver.GameState gameState = GameResolver.resolve(gameBoard.getBoard());
    
            // print the results
            if (gameState == GameResolver.GameState.DRAW) {
                System.out.println(drawMessage);
            } else if (gameState == GameResolver.GameState.X_WON) {
                System.out.println(XWin);
            } else if (gameState == GameResolver.GameState.O_WON) {
                System.out.println(OWin);
            }
        }
        // If the user chose to let computer play against itself
        if (userChoice == 3) {
            // Print the instruction board
            gameBoard.instructionBoard();
    
            // Let the computer place an X
            gameBoard.placePieceRandomly("X");
    
            boolean isGameInProgress = true;
            
            while (isGameInProgress && !gameBoard.isMatrixFull()) {
                // Let the computer place an O and then display the board again
                gameBoard.placePieceRandomly("O");
                gameBoard.displayBoard();
    
                // set game status to in progress
                isGameInProgress = GameResolver.resolve(gameBoard.getBoard()) == GameResolver.GameState.IN_PROGRESS;
    
                // if game is in progress let the computer place an X
                if (isGameInProgress) {
                    gameBoard.placePieceRandomly("X");
                }
            }
    
            // display the board one last time
            gameBoard.displayBoard();
    
            // get the board results to check the winning conditions
            GameResolver.GameState gameState = GameResolver.resolve(gameBoard.getBoard());
    
            // print the results
            if (gameState == GameResolver.GameState.DRAW) {
                System.out.println(drawMessage);
            } else if (gameState == GameResolver.GameState.X_WON) {
                System.out.println(XWin);
            } else if (gameState == GameResolver.GameState.O_WON) {
                System.out.println(OWin);
            }
        }

        // close the scanner
        scanner.close();
    }
}
