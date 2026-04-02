class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList();

        int i, j;
        for (i = 0; i < grid.length; i ++) {
            for (j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        Pair<Integer, Integer> pair;
        int val;
        while (!q.isEmpty()) {
            pair = q.poll();

            i = pair.getKey();
            j = pair.getValue();
            val = grid[i][j];

            if (i > 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = val + 1;
                q.offer(new Pair(i - 1, j));
            }

            if (j > 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = val + 1;
                q.offer(new Pair(i, j - 1));
            }

            if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                grid[i + 1][j] = val + 1;
                q.offer(new Pair(i + 1, j));
            }

            if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                grid[i][j + 1] = val + 1;
                q.offer(new Pair(i, j + 1));
            }
        }

        int max = 2;
        for (i = 0; i < grid.length; i ++) {
            for (j = 0; j < grid[0].length; j ++) {
                System.out.print(grid[i][j] + " ");
                max = grid[i][j] > max ? grid[i][j] : max;

                if (grid[i][j] == 1) {
                    return -1;
                }
            }
            System.out.println();
        }

        return max - 2;
    }
}
