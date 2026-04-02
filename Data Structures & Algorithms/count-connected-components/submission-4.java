class Solution {
    public void explore(List<List<Integer>> neighbours, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neigh : neighbours.get(node)) {
            if (neigh == parent || visited[neigh]) {
                continue;
            }

            explore(neighbours, neigh, node, visited);
        }
    }

    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int parts = 0;

        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < n; i ++) {
            list.add(new ArrayList());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                explore(list, i, -1, visited);
                parts ++;
            }
        }

        return parts;
    }
}
