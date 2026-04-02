class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (var n : stones) {
            pq.add(n);
        }

        for (int i = 0; i < stones.length - 1; i ++) {
            int a = pq.poll();
            int b = pq.poll();

            pq.add(a - b);
        }

        return pq.peek();
    }
}
