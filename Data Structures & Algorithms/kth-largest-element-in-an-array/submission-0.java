class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int size = 0;

        for (int n : nums) {
            if (size < k) {
                pq.add(n);
                size ++;
            } else if (pq.peek() < n) {
                pq.poll();
                pq.add(n);
            }
        }

        return pq.peek();
    }
}
