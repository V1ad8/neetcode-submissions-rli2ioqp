class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        int a, b, c;
        String res;

        for (var tok : tokens) {
            res = tok;

            if (tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/")) {
                b = Integer.valueOf(stack.peek());
                stack.pop();
                a = Integer.valueOf(stack.peek());
                stack.pop();

                switch (tok) {
                    case "+": {
                        c = a + b;
                        break;
                    }
                    case "-": {
                        c = a - b;
                        break;
                    }
                    case "*": {
                        c = a * b;
                        break;
                    }
                    case "/": {
                        c = a / b;
                        break;
                    }
                    default: {
                        c = a;
                    }
                }

                res = Integer.toString(c);
            }

            stack.push(res);
        }

        return Integer.valueOf(stack.peek());
    }
}
