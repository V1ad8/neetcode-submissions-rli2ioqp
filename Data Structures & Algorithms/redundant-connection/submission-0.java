class Solution {
    public boolean findCycle(List<List<Integer>> neighbours, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neigh : neighbours.get(node)) {
            if (neigh == parent) {
                continue;
            }

            if (visited[neigh]) {
                return false;
            }

            if (!findCycle(neighbours, neigh, node, visited)) {
                return false;
            }
        }

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < edges.length; i ++) {
            list.add(new ArrayList());
        }

        for (int[] edge : edges) {
            list.get(edge[0] - 1).add(edge[1] - 1);
            list.get(edge[1] - 1).add(edge[0] - 1);

            if (!findCycle(list, edge[0] - 1, -1, new boolean[edges.length])) {
                return edge;
            }
        }

        return new int[2];
    }
}
