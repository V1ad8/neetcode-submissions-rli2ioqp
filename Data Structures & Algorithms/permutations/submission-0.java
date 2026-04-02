class Solution {
    List<List<Integer>> explore(List<Integer> soFar, int[] nums, Set<Integer> set) {
        List<List<Integer>> res = new ArrayList();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
                soFar.add(n);

                if (soFar.size() == nums.length) {
                    res.add(new ArrayList(soFar));
                } else {
                    res.addAll(explore(soFar, nums, set));
                }

                set.remove(n);
                soFar.remove(soFar.size() - 1);
            }
        }

        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        return explore(new ArrayList(), nums, new HashSet());
    }
}
