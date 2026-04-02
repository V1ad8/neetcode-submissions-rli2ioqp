class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A'] ++;
        }

        for (int num : freq) {
            if (num > 0) {
                pq.add(num);
            }
        }

        List<Integer> list = new ArrayList();
        int counter = 0, mini;
        while (!pq.isEmpty()) {
            mini = 0;
            for (int i = 0; i <= n; i ++) {
                if (pq.isEmpty()) {
                    break;
                }

                int num = pq.poll();
                if (num > 1) {
                    list.add(num - 1);
                }

                mini ++;

                if (list.isEmpty() && pq.isEmpty()) {
                    return counter + mini;
                }
            }
            counter += n + 1;

            for (int num : list) {
                pq.add(num);
            }

            list.clear();
        }

        return counter;
    }
}
