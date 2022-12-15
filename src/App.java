import java.util.Scanner;
import Classes.GameBoard;
import Classes.GameResolver;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);
        // Create a game board object
        GameBoard gameBoard = new GameBoard();
        // Print the instruction board
        gameBoard.instructionBoard();

        // Let the user place an X
        System.out.println("Please enter a position to place your piece: ");

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
                System.out.println("Please enter a position to place your piece: ");
                position = scanner.nextInt();
                gameBoard.placePiece(position, "X");
            }
        }

        // display the board one last time
        gameBoard.displayBoard();

        // get the board results to check the winning conditions
        GameResolver.GameState gameState = GameResolver.resolve(gameBoard.getBoard());

        // print the results
        if (gameState == GameResolver.GameState.DRAW) {
            System.out.println("It's a draw!");
        } else if (gameState == GameResolver.GameState.X_WON) {
            System.out.println("X wins!");
        } else if (gameState == GameResolver.GameState.O_WON) {
            System.out.println("O wins!");
        }

        // close the scanner
        scanner.close();
    }
}
