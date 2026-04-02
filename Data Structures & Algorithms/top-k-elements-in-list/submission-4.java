class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];

        for (var n : nums) {
            freq[n + 1000] ++;
        }

        int i;
        List<Integer> v;
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (i = 0; i < 2001; i ++) {
            v = buckets[freq[i]];
            if (v == null) {
                v = new ArrayList();
            }

            v.add(i - 1000);
            buckets[freq[i]] = v;
        }

        int[] res = new int[k];
        for (i = nums.length; i >= 0 && k != 0; i --) {
            v = buckets[i];
            if (v == null) {
                continue;
            }

            for (int n : v) {
                k --;
                res[k] = n;

                if (k <= 0) {
                    break;
                }
            }
        }

        return res;
    }
}
