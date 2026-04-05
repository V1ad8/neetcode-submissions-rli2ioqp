class Solution {
    public int rec(int n, int[] nums, int[] dp) {
        if (n >= nums.length) {
            return 0;
        }

        if (dp[n] == -1) {
            dp[n] = Math.max(nums[n] + rec(n + 2, nums, dp), rec(n + 1, nums, dp));
        }

        return dp[n];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return rec(0, nums, dp);
    }
}
