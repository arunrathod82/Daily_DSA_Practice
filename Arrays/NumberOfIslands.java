/*
Problem: Number of Islands
Platform: LeetCode
Approach: Depth First Search (DFS)
Time Complexity: O(n × m)
Space Complexity: O(n × m) (recursion stack in worst case)
*/

import java.util.*;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int island = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == '1'){
                    island++;
                    dfs(grid, i, j);
                }
            }
        }

        return island;
    }

    public static void dfs(char[][] grid, int r, int c){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }

        if(grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int result = numIslands(grid);

        System.out.println("Number of Islands: " + result);
    }
}