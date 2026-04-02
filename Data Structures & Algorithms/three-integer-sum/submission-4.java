class Solution {
    public int[] twoSum(int[] numbers, int start, int target) {
        int left = start;
        int right = numbers.length - 1;
        int soFar;

        while (left < right) {
            soFar = numbers[left] + numbers[right];

            if (soFar == target) {
                return new int[]{left, right};
            }

            while (left < right && numbers[left] == numbers[left + 1]) left++;
            while (left < right && numbers[right] == numbers[right - 1]) right--;

            if (soFar < target) {
                left ++;
            } else {
                right --;
            }
        }

        return new int[]{-1, -1};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int[] output = new int[2];
        int j, k;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++ ) {
            int left = i + 1;
            int right = nums.length - 1;
            int soFar;
            int target = -nums[i];

            while (left < right) {
                soFar = nums[left] + nums[right];

                if (soFar == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                }

                if (soFar < target) {
                    left ++;
                } else {
                    right --;
                }
            }

            while (nums[i] == nums[i + 1] && i < nums.length - 2) {
                i ++;
            }
        }

        return res;
    }
}
