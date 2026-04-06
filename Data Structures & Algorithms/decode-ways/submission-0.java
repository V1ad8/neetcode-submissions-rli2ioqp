class Solution {
    public int count(int n, String s, int[] dp) {
        if (n >= s.length()) {
            return 1;
        }

        if (s.charAt(n) == '0') {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int res = count(n + 1, s, dp);

        if (n + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(n, n + 2));
            if (10 <= num && num <= 26) {
                res += count(n + 2, s, dp);
            }
        }

        dp[n] = res;
        return dp[n];
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return count(0, s,dp);
    }
}
