class Solution {
    public int swimInWater(int[][] grid) {
        int[][] mat = new int[grid.length][grid[0].length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0], y = top[1], max = top[2];

            if (x > 0 && mat[x - 1][y] > Math.max(max, grid[x - 1][y])) {
                mat[x - 1][y] = Math.max(max, grid[x - 1][y]);
                pq.offer(new int[]{x - 1, y, mat[x - 1][y]});
            }

            if (y > 0 && mat[x][y - 1] > Math.max(max, grid[x][y - 1])) {
                mat[x][y - 1] = Math.max(max, grid[x][y - 1]);
                pq.offer(new int[]{x, y - 1, mat[x][y - 1]});
            }

            if (x < grid.length - 1 && mat[x + 1][y] > Math.max(max, grid[x + 1][y])) {
                mat[x + 1][y] = Math.max(max, grid[x + 1][y]);
                pq.offer(new int[]{x + 1, y, mat[x + 1][y]});
            }

            if (y < grid[0].length - 1 && mat[x][y + 1] > Math.max(max, grid[x][y + 1])) {
                mat[x][y + 1] = Math.max(max, grid[x][y + 1]);
                pq.offer(new int[]{x, y + 1, mat[x][y + 1]});
            }
        }

        return mat[grid.length - 1][grid[0].length - 1];
        
    }
}
