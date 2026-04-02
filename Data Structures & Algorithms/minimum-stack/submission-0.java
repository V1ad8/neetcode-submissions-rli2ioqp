class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack();
        min = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);

        if (min.isEmpty() || val < min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
