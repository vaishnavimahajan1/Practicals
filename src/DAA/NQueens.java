package DAA;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int N = scanner.nextInt();
        int[][] board = new int[N][N];
        
        if (solveNQueens(board, 0, N)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
    
    public static boolean solveNQueens(int[][] board, int col, int N) {
        if (col == N) {
            return true;
        }
        
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;
                if (solveNQueens(board, col + 1, N)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }
    
    public static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
