class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();

        int n = heights.length;
        int[] left = new int[n];

        for (int i = 0; i < n; i ++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        stack.clear();
        int[] right = new int[n];

        int res = 0;
        for (int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = stack.peek() - 1;
            }

            stack.push(i);

            int area = heights[i] * (right[i] - left[i] + 1);
            res = area > res ? area : res;
        }

        return res;
    }
}
