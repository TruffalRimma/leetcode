// Number Of Islands

import java.util.Arrays;

public class Task200 {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    helper(grid, i, j);
                    System.out.println(Arrays.deepToString(grid));
                }
            }
        }

        return result;
    }

    public static void helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        helper(grid, i + 1, j); // down
        helper(grid, i - 1, j); // up
        helper(grid, i, j + 1); // right
        helper(grid, i, j - 1); // left
    }
}
