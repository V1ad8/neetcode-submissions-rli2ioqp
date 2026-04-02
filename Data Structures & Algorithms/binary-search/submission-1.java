class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right) {
            middle = (right + left) / 2;

            if (nums[right] == target) {
                return right;
            }

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[left] == target) {
                return left;
            }

            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;

    }
}
