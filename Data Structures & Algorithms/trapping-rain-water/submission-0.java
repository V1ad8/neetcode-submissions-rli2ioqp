class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int max = 0;
        for (int i = 0; i < n; i ++) {
            left[i] = max;
            max = height[i] > max ? height[i] : max;
        }

        max = 0;
        for (int i = n - 1; i >= 0; i --) {
            right[i] = max;
            max = height[i] > max ? height[i] : max;
        }

        int area, res = 0;
        for (int i = 0; i < n; i ++) {
            if (left[i] < right[i]) {
                area = left[i] - height[i];
            } else {
                area = right[i] - height[i];
            }

            if (area > 0) {
                res += area;
            }
        }

        return res;
    }
}
