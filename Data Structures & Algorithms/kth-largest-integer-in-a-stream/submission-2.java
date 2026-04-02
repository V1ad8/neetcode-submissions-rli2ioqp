class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        size = 0;

        for (var n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if (size < k) {
            pq.add(val);
            size ++;
        } else {
            if (pq.peek() <= val) {
                pq.poll();
                pq.add(val);
            }
        }

        return pq.peek();
    }
}
