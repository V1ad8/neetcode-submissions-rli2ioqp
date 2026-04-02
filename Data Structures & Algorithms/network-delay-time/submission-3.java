class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList();
        for (int i = 0; i < n; i ++) {
            adj.add(new ArrayList());
        }

        for (int[] time : times) {
            adj.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        pq.offer(new int[]{0, k - 1});

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int path = top[0];
            int node = top[1];

            if (path > dist[node]) {
                continue;
            }

            for (int[] pair : adj.get(node)) {
                int neigh = pair[0];
                int cost = pair[1];

                if (dist[neigh] > cost + dist[node]) {
                    dist[neigh] = cost + dist[node];
                    pq.offer(new int[]{dist[neigh], neigh});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i ++) {
            res = dist[i] > res ? dist[i] : res;
        }
        System.out.println();

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
