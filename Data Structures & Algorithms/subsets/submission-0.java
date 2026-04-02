class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();

        for (int mask = 0; mask < (1 << nums.length); mask ++) {
            List<Integer> list = new ArrayList();

            for (int i = 0; i < nums.length; i ++) {
                if ((mask & (1 << i)) != 0) {
                    list.add(nums[i]);
                }
            }

            res.add(list);
        }

        return res;
    }
}
