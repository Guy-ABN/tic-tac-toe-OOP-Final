# Tic Tac Toe OOP Project

## Getting Started

The goal of this project is to test your ability to use the knowledge of Java that you have
obtained in the course. The focus of this project is on object-oriented programming. The goal
is to create a classic tic-tac-toe game. The user will be playing against a computer opponent
that will pick an open spot on the board.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Program Functionality

1.1 Program Steps
1.1.1. Display the current board state.
1.1.2. Take in a row and column as a position on the board for the user’s move.
        a) If the user enters anything besides a valid row and column, tell the user it is
    invalid.
            • Start over from step 2.
        b) If the user enters a position that already has an “X” or an “O”, then tell the user
    that the position is occcupied.
            • Start over from step 2.
        c) If the user enters a valid, unoccupied row and column, this should be considered
    the user’s move.
            i. Display the board, now updated with the player’s move
            ii. If the user’s move results in a win, tell the user that she has won.
                • Terminate the program.
            iii. If the user’s move results in a tie (cat), tell the user that the game has ended
        in a tie (cat).
                • Terminate the program.
            iv. The computer opponent should then randomly choose an open spot on the
        board.
            v. Display the board, now updated with the computer’s move
            vi. If the computer’s move results in a win, tell the user that the computer has
        won.
                • Terminate the program.
            vii. Go to step 2.
1.2 Details
    • The board should be represented by a 3 x 3 (two dimensional) array of characters.
    • It should be obvious to the user how to enter coordinates and what the state of the
board is at any time.
    • The computer’s moves should be completely random at the least. If you want to do
more intellegent move making, you may recieve extra points.
    • In my example, the user goes first. If you want to randomly select which player goes
first, this is also acceptable and will get you bonus points.
    • All the normal rules to tic-tac-toe apply to this game. If you do not know the rules of
tic-tac-toe, or have a specific question on the rules, feel free to ask the instructor.

## Possible Object Design

1. Board - An object representing a tic-tac-toe board
a) Attributes
• gameBoard - Two-dimensional character array representing the board
b) Methods
i. Constructors
a. Board() - Initializes the board to an empty board
b. Board(char [][] inBoard) - Initializes the board to inBoard
ii. Accessors
a. char[][] getGameBoard() - returns the game board
b. void printBoard() - prints the board to the screen
c. boolean submitMove(String move, char player) - adds the move to
the board, and returns true if the space specified in the move is not
taken. If the space is taken, do not add the move and return false.
d. boolean isWinner(char player) - Returns true if the player whose
marker is passed as a parameter has won the game, false otherwise.
e. boolean isCat() - Returns true if there is a CAT(tie), false otherwise.
f. boolean isMoveValid(String move) - Returns true if the parameter is a
move on the board, otherwise it returns false
2. Player – An object representing a player of the tic-tac-toe game
a) Attributes
• char marker - Character representing whether this player is using X or O as
her marker
• boolean isHuman - Boolean indicating if the player is a human player or a
computer player
b) Methods
i. Constructors
a. Player() - Initializes the marker to X and isHuman to true
b. Player(boolean inIsHuman) - Initializes isHuman to inIsHuman and if
inIsHuman is true, marker to X, otherwise marker to O
c. Player(boolean inIsHuman, char inMarker) - Initializes isHuman to
inIsHuman and marker to X if inMarker is X or x, otherwise marker
to O
ii. Accessors
a. char getMarker() - Returns the player’s marker
b. boolean getIsHuman() - Returns whether the player is human or not
c. String getPlayerMove() - Returns the move from the player (either
from human or computer).
d. String getHumanMove() - Prompts the user for a move, retreieves
input from the keyboard, and returns it.
e. String generateComputerMove() - Returns a move randomly
generated.
