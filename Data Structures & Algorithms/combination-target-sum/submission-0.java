class Solution {
    public List<List<Integer>> explore(int[] nums, int target, List<Integer> soFar, int start) {
        if (soFar == null) {
            soFar = new ArrayList();
        }

        List<List<Integer>> res = new ArrayList();
        if (0 == target) {
            res.add(new ArrayList<>(soFar));
            return res;
        }

        int checking;
        for (int i = start; i < nums.length; i ++) {
            int n = nums[i];

            checking = target - n;

            if (checking >= 0) {
                soFar.add(n);
                List<List<Integer>> list = explore(nums, checking, soFar, i);
                soFar.remove(soFar.size() - 1);

                res.addAll(list);
            }
        }

        return res;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return explore(nums, target, null, 0);
    }
}
