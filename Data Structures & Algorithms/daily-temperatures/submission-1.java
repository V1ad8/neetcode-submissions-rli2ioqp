class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> idx = new Stack();

        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && temperatures[i] >= stack.peek()) {
                stack.pop();
                idx.pop();
            }

            System.out.println(stack);

            if (idx.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = idx.peek() - i;
            }

            stack.push(temperatures[i]);
            idx.push(i);
        }

        return res;
    }
}
