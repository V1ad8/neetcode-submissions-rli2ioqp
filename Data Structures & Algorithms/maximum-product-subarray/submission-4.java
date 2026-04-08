class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1;
        int minProd = 1;

        int global = -11;

        for (int n : nums) {
            int cand1 = n * maxProd;
            int cand2 = n * minProd;

            maxProd = Math.max(n, Math.max(cand1, cand2));
            minProd = Math.min(n, Math.min(cand1, cand2));
            global = maxProd > global ? maxProd : global;

            System.out.println(maxProd + " " + minProd);
        }

        return global;
    }
}
