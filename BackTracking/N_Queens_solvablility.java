public class N_Queens_solvablility {
    public static boolean isSafe(char board[][], int row, int col) {// function to find out is the position safe for
        // placement

        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static boolean nQueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            // displayBoard(board);
            count++;
            return true;
        }
        // coloum loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens(board, row + 1)) {
                    return true;
                } // add Q to all the rows available without considering
                board[row][j] = 'X';
            }

        }
        return false;
    }

    public static void displayBoard(char board[][]) {
        System.out.println("---------------printing board----------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0; // to count how many ways n_queens can be solved.

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        // initialize the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';

            }
        }
        if (nQueens(board, 0)) {
            System.out.println("yes solution is possible");
            displayBoard(board);
        } else {
            System.out.println("the solution is not possible");
        }

    }
}
