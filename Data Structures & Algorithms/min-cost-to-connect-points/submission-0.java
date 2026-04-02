class DistinctSet {
    int[] parent, rank;

    public DistinctSet (int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i ++) {
            parent[i] = i;
            rank[i] = i;
        }
    }

    public boolean sameSet(int i, int j) {
        return find(i) == find(j);
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }

        return parent[i];
    }

    public void union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);

        if (rank[f1] > rank[f2]) {
            parent[f2] = f1;
            rank[f1] += rank[f2];
        } else {
            parent[f1] = f2;
            rank[f2] += rank[f1];
        }
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList();

        for (int p1 = 0; p1 < points.length; p1++) {
            for (int p2 = p1 + 1; p2 < points.length; p2++) {
                int d = Math.abs(points[p1][0] - points[p2][0])
                    + Math.abs(points[p1][1] - points[p2][1]);

                edges.add(new int[]{p1, p2, d});
            }
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        DistinctSet DS = new DistinctSet(points.length);
        int res = 0;
        int selected = 0;

        for (var e : edges) {
            int s = e[0], d = e[1], c = e[2];

            if (!DS.sameSet(s, d)) {
                DS.union(s, d);
                res += c;

                if (++selected == points.length) {
                    break;
                }
            }
        }

        return res;
    }
}
