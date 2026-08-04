/*
Problem: Nearest Exit from Entrance in Maze
Platform: LeetCode
Approach: Breadth-First Search (BFS)
Time Complexity: O(m × n)
Space Complexity: O(m × n)

m = number of rows
n = number of columns
*/

import java.util.*;

public class NearestExitFromEntranceInMaze {

    public static int nearestExit(
            char[][] maze,
            int[] entrance) {

        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
                entrance[0],
                entrance[1]
        });

        // Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = {
                {-1,0}, // Up
                {1,0},  // Down
                {0,-1}, // Left
                {0,1}   // Right
        };

        int steps = 0;

        // BFS
        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Check if current cell is an exit
                if((row == 0 ||
                    row == rows - 1 ||
                    col == 0 ||
                    col == cols - 1) &&

                    !(row == entrance[0] &&
                      col == entrance[1])) {

                    return steps;
                }

                for(int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 &&
                       newRow < rows &&
                       newCol >= 0 &&
                       newCol < cols &&
                       maze[newRow][newCol] == '.') {

                        maze[newRow][newCol] = '+';

                        queue.offer(new int[]{
                                newRow,
                                newCol
                        });
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {

        char[][] maze = {
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };

        int[] entrance = {1,2};

        int result =
                nearestExit(maze, entrance);

        System.out.println(
                "Nearest Exit Steps: "
                + result
        );
    }
}