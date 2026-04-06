class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length() + 1];

        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i ++) {
            dp[i][i] = true;
            dp[i][i + 1] = true;
        }

        for (int len = 2; len <= s.length(); len ++) {
            for (int i = 0; i <= s.length() - len; i ++) {
                dp[i][i + len] = s.charAt(i) == s.charAt(i + len - 1) && dp[i + 1][i + len - 1];

                if (len > maxLen && dp[i][i + len]) {
                    maxLen = len;
                    res = s.substring(i, i + len);
                }
            }
        }

        return res;
    }
}
