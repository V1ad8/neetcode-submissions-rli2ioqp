class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        char c, comp;
        for (int i = 0; i < s.length(); i ++) {
            c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                comp = c == ')' ? '(' :
                        c == '}' ? '{' : '[';

                if (stack.isEmpty() || stack.peek() != comp) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
