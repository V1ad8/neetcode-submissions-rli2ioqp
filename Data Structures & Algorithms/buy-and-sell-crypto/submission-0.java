class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy[] = new int[n];

        int min = prices[0];
        for (int i = 1; i < n; i ++) {
            buy[i] = min;
            min = prices[i] < min ? prices[i] : min;
        }

        int res = 0;
        int profit;
        for (int i = 1; i < n; i ++) {
            profit = prices[i] - buy[i];
            res = profit > res ? profit : res;
        }

        return res;
    }
}
