
public class SudokuInChar {

    public static boolean isSafe(char[][] board, int row, int col, char digit) {
        // columm safe
        for (int i = 0; i <= 8; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        for (int j = 0; j <= 8; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }
        int sr = (row / 3) * 3;// starting row
        int sc = (col / 3) * 3;// starting col
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(char sudoku[][], int row, int col) {

        // base case
        if (row == 9 && col == 0) {// goes out of the sudoku after solving
            return true;
        }

        // recursion case
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        if (sudoku[row][col] != '.') {// jump to next cell if the current cell is not empty
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, (char) (digit + '0'))) {
                sudoku[row][col] = (char) (digit + '0');
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = '.';
            }
        }
        return false;
    }

    public static void displayBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        if (sudokuSolver(board, 0, 0)) {
            displayBoard(board);
        } else {
            System.out.println("ThiS is not solvable.");

        }

    }
}
