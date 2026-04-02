class Solution {
    public void explore(int[][] grid, int i, int j, int distance) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == -1 || (grid[i][j] <= distance && grid[i][j] != 0)) {
            return;
        }

        if (grid[i][j] == 0) {
            distance = 0;
        }

        grid[i][j] = distance;

        explore(grid, i - 1, j, distance + 1);
        explore(grid, i, j - 1, distance + 1);
        explore(grid, i + 1, j, distance + 1);
        explore(grid, i, j + 1, distance + 1);
    }

    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 0) {
                    explore(grid, i, j, 0);
                    return;
                }
            }
        }
    }
}
