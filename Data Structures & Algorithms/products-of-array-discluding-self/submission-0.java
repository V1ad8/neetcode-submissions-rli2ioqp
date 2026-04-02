class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] sufix = new int[n];

        for (int i = 0; i < n; i ++) {
            prefix[i] = 1;
            sufix[i] = 1;
        }

        for (int i = 0; i < n; i ++) {
            if (i > 0) {
                prefix[i] *= nums[i - 1] * prefix[i - 1];
            }

            if (i > 0) {
                sufix[n - 1 - i] = nums[n - i] * sufix[n - i];
            }
        }

        for (int i = 0; i < n; i ++) {
            prefix[i] *= sufix[i];
        }

        return prefix;
    }
}  
