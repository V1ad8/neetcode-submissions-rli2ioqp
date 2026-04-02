class Solution {
    public void explore(List<List<Integer>> neighbours, int node, int parent, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int neigh : neighbours.get(node)) {
            if (neigh == parent) {
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
            int i = edge[0];
            int j = edge[1];

            list.get(i).add(j);
            list.get(j).add(i);
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
