class Solution {
    List<List<Integer>> explore(List<Integer> soFar, int[] nums, int idx) {
        List<List<Integer>> res = new ArrayList();
        if (idx >= nums.length) {
            res.add(new ArrayList(soFar));
            return res;
        }

        int next = idx + 1;
        while (next < nums.length && nums[next - 1] == nums[next]) {
            next ++;
        }

        res.addAll(explore(soFar, nums, next));

        for (int i = idx; i < next; i++) {
            soFar.add(nums[idx]);
            res.addAll(explore(soFar, nums, next));
        }

        for (int i = idx; i < next; i++) {
            soFar.remove(soFar.size() - 1);
        }

        return res;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return explore(new ArrayList(), nums, 0);
    }
}
