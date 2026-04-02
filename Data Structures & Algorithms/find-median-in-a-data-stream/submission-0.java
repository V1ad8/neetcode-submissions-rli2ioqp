class MedianFinder {
    PriorityQueue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        while (left.size() - right.size() > 1) {
            right.add(left.poll());
        }

        while(right.size() - left.size() > 1) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if (right.size() > left.size()) {
            return right.peek();
        } else if (right.size() < left.size()) {
            return left.peek();
        } else {
            return (right.peek() + left.peek()) / 2.0;
        }
    }
}
