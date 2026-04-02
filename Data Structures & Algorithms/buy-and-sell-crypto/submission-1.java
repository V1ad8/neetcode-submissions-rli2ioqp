class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int res = 0;

        while (sell < prices.length) {
            if (prices[buy] > prices[sell]) {
                buy = sell;
                sell ++;
            } else {
                if (prices[sell] - prices[buy] > res) {
                    res = prices[sell] - prices[buy];
                }
                sell ++;
            }
        }

        return res;
    }
}
