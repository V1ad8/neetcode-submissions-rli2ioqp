class Element {
    public int value, index;

    public Element(int aValue, int anIndex) {
        value = aValue;
        index = anIndex;
    }

    public String toString() {
        return "(" + value + " at " + index + ")";
    }
}

public class CustomComparator implements Comparator<Element> {
    @Override
    public int compare(Element o1, Element o2) {
        return o2.value - o1.value;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new CustomComparator());

        for (int i = 0; i < k; i ++) {
            pq.add(new Element(nums[i], i));
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i ++) {
            while (pq.peek().index < i) {
                pq.remove();
            }

            res[i] = pq.peek().value;

            if (i + k < n) {
                pq.add(new Element(nums[i + k], i + k));
            }
        }

        return res;
    }
}
