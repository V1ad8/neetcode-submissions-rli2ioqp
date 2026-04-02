class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int res = 0, area;

        while(left < right) {
            if (heights[left] < heights[right]) {
                area = heights[left] * (right - left);
                left ++;
            } else {
                area = heights[right] * (right - left);
                right --;
            }
            
            res = area > res ? area : res;
        }

        return res;
    }
}
