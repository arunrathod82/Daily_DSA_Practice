/*
Problem: Surrounded Regions
Platform: LeetCode
Approach: DFS from Boundary
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns

(The recursion stack can take up to O(m × n) space in the worst case.)
*/

import java.util.*;

public class SurroundedRegions {

    public static void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: DFS from first and last row
        for(int col = 0; col < cols; col++) {

            if(board[0][col] == 'O') {
                dfs(board, 0, col);
            }

            if(board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col);
            }
        }

        // Step 2: DFS from first and last column
        for(int row = 0; row < rows; row++) {

            if(board[row][0] == 'O') {
                dfs(board, row, 0);
            }

            if(board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1);
            }
        }

        // Step 3: Convert remaining O -> X
        //         Restore T -> O
        for(int row = 0; row < rows; row++) {

            for(int col = 0; col < cols; col++) {

                if(board[row][col] == 'O') {
                    board[row][col] = 'X';
                }

                else if(board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private static void dfs(
            char[][] board,
            int row,
            int col) {

        int rows = board.length;
        int cols = board[0].length;

        if(row < 0 ||
           row >= rows ||
           col < 0 ||
           col >= cols ||
           board[row][col] != 'O') {

            return;
        }

        // Mark boundary-connected region
        board[row][col] = 'T';

        dfs(board, row - 1, col); // Up
        dfs(board, row + 1, col); // Down
        dfs(board, row, col - 1); // Left
        dfs(board, row, col + 1); // Right
    }

    public static void main(String[] args) {

        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        solve(board);

        System.out.println("Board After Solving:");

        for(char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}