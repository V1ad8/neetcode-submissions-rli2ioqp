class Solution {
    public void color(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = color;

        color(grid, i - 1, j, color);
        color(grid, i, j - 1, color);
        color(grid, i + 1, j, color);
        color(grid, i, j + 1, color);
    }

    public int numIslands(char[][] grid) {
        int color = 2;

        int gridI[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < gridI.length; i ++) {
            for (int j = 0; j < gridI[0].length; j ++) {
                gridI[i][j] = grid[i][j] - '0';
            }
        }

        for (int i = 0; i < gridI.length; i ++) {
            for (int j = 0; j < gridI[0].length; j ++) {
                if (gridI[i][j] == 1) {
                    color(gridI, i, j, color ++);
                }
            }
        }

        return color - 2;
    }
}
