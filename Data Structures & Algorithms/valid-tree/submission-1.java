class Solution {
    public boolean explore(int[][] edges, int node, int parent, boolean[] visited) {
        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int[] edge : edges) {
            if (edge[0] == node) {
                if (edge[1] == parent) {
                    continue;
                }

                if (!explore(edges, edge[1], node, visited)) {
                    return false;
                }
            } else if (edge[1] == node) {
                if (edge[0] == parent) {
                    continue;
                }

                if (!explore(edges, edge[0], node, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        if (!explore(edges, 0, -1, visited)) {
            return false;
        }

        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
