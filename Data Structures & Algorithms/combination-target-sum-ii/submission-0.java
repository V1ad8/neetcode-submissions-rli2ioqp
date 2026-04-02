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

        for (int i = start; i < nums.length; i ++) {
            if (target >= nums[i]) {
                soFar.add(nums[i]);
                List<List<Integer>> list = explore(nums, target - nums[i], soFar, i + 1);
                soFar.remove(soFar.size() - 1);

                res.addAll(list);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i ++;
            }
        }

        return res;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return explore(candidates, target, null, 0);
    }
}
