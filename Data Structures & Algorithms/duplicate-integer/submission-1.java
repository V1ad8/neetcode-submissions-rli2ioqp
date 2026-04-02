

class Solution {
    private HashSet<Integer> viewed = new HashSet<Integer>();

    public boolean hasDuplicate(int[] nums) {
        for (int num : nums) {
            if (viewed.add(num) == false) {
                return true;
            }
        }

        return false;
    }
}