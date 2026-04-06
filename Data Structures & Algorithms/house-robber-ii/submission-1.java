class Solution {
    public int rec(int n, int[] nums, int[] dp, int last) {
        if (n > last) {
            return 0;
        }

        if (dp[n] == -1) {
            dp[n] = Math.max(nums[n] + rec(n + 2, nums, dp, last),
                            rec(n + 1, nums, dp, last));
        }

        return dp[n];
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(rec(0, nums, dp1, nums.length - 2),
                        rec(1, nums, dp2, nums.length - 1));
    }
}
