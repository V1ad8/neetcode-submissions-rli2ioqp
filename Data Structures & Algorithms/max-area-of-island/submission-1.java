class Solution {
    public int color(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = color;

        int res = 1;
        res += color(grid, i - 1, j, color);
        res += color(grid, i, j - 1, color);
        res += color(grid, i + 1, j, color);
        res += color(grid, i, j + 1, color);

        return res;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int color = 2;

        int max = 0;

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    int area = color(grid, i, j, color ++);
                    max = area > max ? area : max;
                }
            }
        }

        return max;
    }
}
