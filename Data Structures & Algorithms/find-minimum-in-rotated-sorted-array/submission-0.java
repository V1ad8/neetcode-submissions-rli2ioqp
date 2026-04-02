class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left < right) {
            middle = (right + left) / 2;


            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }

            System.out.println(left + " " + right);
        }

        return nums[left];
    }
}
