class Solution {
    public int rec(String s, int i, List<String> wordDict, int[] dp) {
        if (i >= s.length()) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        System.out.println(s.substring(i));

        for (String word : wordDict) {
            if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                if (rec(s, i + word.length(), wordDict, dp) == 1) {
                    dp[i] = 1;
                    return dp[i];
                }
            }
        }

        dp[i] = 0;
        return dp[i];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return rec(s, 0, wordDict, dp) == 1;
    }
}
