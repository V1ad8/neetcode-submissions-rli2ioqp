class Solution {
    public int rec(int[] nums, int i, int prevIdx, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][prevIdx + 1] != -1) {
            return dp[i][prevIdx + 1];
        }

        int noTake = rec(nums, i + 1, prevIdx, dp);

        int take = 0;
        if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
            take = 1 + rec(nums, i + 1, i, dp);
        }

        dp[i][prevIdx + 1] = Math.max(take, noTake);
        return dp[i][prevIdx + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return rec(nums, 0, -1, dp);
    }
}
