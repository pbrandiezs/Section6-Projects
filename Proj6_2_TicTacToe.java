import java.util.Objects;
import java.util.Scanner;

public class Proj6_2_TicTacToe {
    public static void main(String[] args) {
        String [][] board = new String[3][3];


        board = initializeBoard(board);
        printBoard(board);

        runGame(board);
    }

    public static void runGame(String[][]board) {
        int[] guess;
        guess = new int[1];
        String player = "X";
        String winner = " ";

        do {
            // make a guess
            System.out.println("\nPlayer " + player);
            guess = getUserInput();
            System.out.println("Guess is " + guess[0] + ", " + guess[1]);
            if(cellAlreadyOccupied(board, guess)) {
                System.out.println("Position already occupied!");
            } else {
                board[guess[0]][guess[1]] = player;
                printBoard(board);
                if (player.equals("X")) {
                    player = "O";
                } else player = "X";
            }
            winner = getWinner(board);
        } while (winner.equals(" ") && !isBoardFull(board));

        if (winner.equals(" ")) {
            System.out.println("Board is full!  NO winner!!!!");
        } else {
            System.out.println("Winner is " + winner + "!!!");
        }
    }

    public static int[] getUserInput() {
        // gets user input, and if valid, sets the game board appropriately

        int i, j;
        int[] guess;
        guess = new int[2];
        boolean validGuess = false;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter coordinate i (0, 1, 2)?");
            i = keyboard.nextInt();
            keyboard.nextLine();
            System.out.print("Enter coordinate j (0, 1, 2)?");
            j = keyboard.nextInt();
            keyboard.nextLine();

            guess[0] = i;
            guess[1] = j;

            if (guess[0] >= 0 && guess[0] <= 2) {
                if (guess[1] >= 0 && guess[1] <= 2) {
                    validGuess = true;
                } else System.out.println("Invalid!");
            } else System.out.println("Invalid!");
        } while (validGuess == false);

        return guess;
    }

    public static boolean cellAlreadyOccupied(String[][]board, int[]guess) {
        // returns true if a given cell (by row and column) is already occupied
        if (!Objects.equals(board[guess[0]][guess[1]], " ")) {
            return true;
        } else return false;
    }

    public static String getWinner(String[][] board) {
        //returns "X", "O" if there is a clear winner, or " " if there is no winner yet
        // Check rows
        for (int i=0;i<=2;i++) {
            if ((board[i][0].equals(board[i][1])) && (board[i][1].equals(board[i][2]))) {
                return board[i][0];
            }
        }
        // Check cols
        for (int j=0;j<=2;j++) {
            if ((board[0][j].equals(board[1][j])) && (board[1][j].equals(board[2][j]))) {
                return board[0][j];
            }
        }
        // Check diag
        if ((board[0][0].equals(board[1][1])) && (board[1][1].equals(board[2][2]))) {
            return board[0][0];
        }
        if ((board[2][0].equals(board[1][1])) && (board[1][1].equals(board[0][2]))) {
            return board[2][0];
        }

        return " ";


    }

    public static boolean isBoardFull(String[][] board) {
        // returns if the board is full or not
        for (int i=0;i<=2;i++) {
            for (int j=0;j<=2;j++) {
                if (Objects.equals(board[i][j], " ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String[][] initializeBoard(String[][] twoDArray){
        String[][] grid = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };
        twoDArray = grid;
        return twoDArray;
    }

    public static void printBoard(String[][] twoDArray) {
        for(int i = 0; i < twoDArray.length; i++) {
            for(int j =0; j < twoDArray[i].length;j++) {
                System.out.print(twoDArray[i][j]);
                if (j < twoDArray.length) {
                    System.out.print("|");
                }
            }
            System.out.println("\n------");
        }
    }
}
