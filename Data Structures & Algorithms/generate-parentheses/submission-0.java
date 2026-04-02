class Solution {
    public boolean valid(String str) {
        Stack<Boolean> s = new Stack();

        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);

            if (c == '(') {
                s.push(true);
            } else if (c == ')') {
                if (s.isEmpty()) {
                    return false;
                }

                s.pop();
            } else {
                return false;
            }
        }

        return s.isEmpty();
    }

    public List<String> explore(String soFar, int n, int open, int closed) {
        List<String> res = new ArrayList();
        if (soFar.length() == 2 * n && valid(soFar)) {
            res.add(soFar);
            return res;
        }

        if (open > n || closed > n) {
            return res;
        }

        String op1 = soFar + "(";
        String op2 = soFar + ")";

        res.addAll(explore(op1, n, open + 1, closed));
        res.addAll(explore(op2, n, open, closed + 1));

        return res;
    }
    
    public List<String> generateParenthesis(int n) {
        return explore("", n, 0, 0);
    }
}
