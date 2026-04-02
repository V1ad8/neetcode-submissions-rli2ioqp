class Solution {
    public void explore(int[][] edges, int node, int parent, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int[] edge : edges) {
            if (edge[0] == node) {
                if (edge[1] == parent) {
                    continue;
                }

                explore(edges, edge[1], node, visited);
            } else if (edge[1] == node) {
                if (edge[0] == parent) {
                    continue;
                }

                explore(edges, edge[0], node, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int parts = 0;

        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                explore(edges, i, -1, visited);
                parts ++;
            }
        }

        return parts;
    }
}
