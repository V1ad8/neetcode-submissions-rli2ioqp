class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();

        for (var n : nums) {
            set.add(n);
        }

        int res = 0, len;
        for (var n : set) {
            if (set.contains(n - 1)) {
                continue;
            }

            for (len = 1; len < nums.length; len ++) {
                if (!set.contains(n + len)) {
                    break;
                }
            }

            if (len > res) {
                res = len;
            }
        }

        return res;
    }
}
