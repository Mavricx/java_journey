package Java_DSA_Questions.Other_Leetcode_Problems;

public class Set_matrix_zeros {

    public static void setZeroes1(int[][] matrix) {// O(m*n) time and O(m+n) space
        int m = matrix.length;// no of rows
        int n = matrix[0].length;// no of cols
        int rowNo[] = new int[m];
        int colNo[] = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowNo[i] = 1;// mark in the remembering array
                    colNo[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowNo[i] == 1 || colNo[j] == 1) {// check and turn them to zero..
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;// no of rows
        int n = matrix[0].length;// no of cols
        // int rowNo[]= new int[m];
        // int colNo[]= new int[n];

        int col0 = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;// mark the 1st row and column(except the 1st element)
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;// to remember for the 1st col only
                }
            }
        }
        // don't touch the 1st row and 1st col and turn zero the required elements.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // now check the 1st element and turn every element of the 1st row to zero if
        // required.
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        // check the extra variable and turn every element of the 1st col to zero if
        // required.
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
    public static void main(String[] args) {
        int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
