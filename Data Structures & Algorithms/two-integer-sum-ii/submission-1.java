class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        int soFar;

        while (left < right) {
            soFar = numbers[left] + numbers[right];

            if (soFar == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }

            if (soFar < target) {
                left ++;
            } else {
                right --;
            }
        }

        return res;
    }
}
