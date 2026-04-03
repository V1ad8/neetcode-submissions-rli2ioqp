class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < k + 1; i ++) {
            int[] tmp = dist.clone();

            for (int[] e : flights) {
                int s = e[0], d = e[1], c = e[2];

                if (dist[s] != Integer.MAX_VALUE && dist[s] + c < tmp[d]) {
                    tmp[d] = dist[s] + c;
                }
            }

            dist = tmp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
