class Solution {
    public final int INF = (int)1e3 + 1;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                mat[i][j] = i == j ? 0 : INF;
            }
        }

        for (int[] ent : times) {
            mat[ent[0] - 1][ent[1] - 1] = ent[2];
        }

        for (int m = 0; m < n; m ++) {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (mat[i][m] != INF && mat[m][j] != INF && mat[i][j] > mat[i][m] + mat[m][j]) {
                        mat[i][j] = mat[i][m] + mat[m][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        int res = 0;
        for (int i = 0; i < n; i ++) {
            if (mat[k - 1][i] == INF) {
                return -1;
            }

            res = mat[k - 1][i] > res ? mat[k - 1][i] : res;
        }

        return res;
    }
}
