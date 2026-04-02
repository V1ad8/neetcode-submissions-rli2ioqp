class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];

        for (int i = 0; i < 2001; i ++) {
            freq[i] = 0;
        }

        for (var n : nums) {
            freq[n + 1000] ++;
        }

        Map<Integer, List<Integer>> map = new HashMap();

        for (int i = 0; i < 2001; i ++) {
            var v = map.get(freq[i]);
            if (v == null) {
                v = new ArrayList();
            }

            v.add(i - 1000);
            map.put(freq[i], v);
        }

        int[] res = new int[k];
        for (int i = nums.length; i >= 0 && k != 0; i --) {
            var v = map.get(i);
            if (v == null) {
                continue;
            }

            for (var n : v) {
                k --;
                res[k] = n;

                System.out.println(n);

                if (k <= 0) {
                    break;
                }
            }
        }

        return res;
    }
}
