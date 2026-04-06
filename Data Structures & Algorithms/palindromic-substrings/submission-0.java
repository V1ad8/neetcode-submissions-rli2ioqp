class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length() + 1];

        for (int i = 0; i < s.length(); i ++) {
            dp[i][i] = true;
            dp[i][i + 1] = true;
        }

        int n = s.length();
        for (int len = 2; len <= s.length(); len ++) {
            for (int i = 0; i <= s.length() - len; i ++) {
                dp[i][i + len] = s.charAt(i) == s.charAt(i + len - 1) && dp[i + 1][i + len - 1];

                if (dp[i][i + len]) {
                    n ++;
                }
            }
        }

        return n;
    }
}
