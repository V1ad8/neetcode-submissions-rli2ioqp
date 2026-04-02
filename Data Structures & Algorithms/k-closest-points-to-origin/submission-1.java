class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, int[]>> pq =
            new PriorityQueue<>((a, b) -> Double.compare(a.getKey(), b.getKey()));

        for (var p : points) {
            int x = p[0];
            int y = p[1];

            double d = Math.sqrt(x * x + y * y);

            pq.add(new Pair(d, p));
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            var pair = pq.poll();
            res[i] = pair.getValue();
        }

        return res;

    }
}
