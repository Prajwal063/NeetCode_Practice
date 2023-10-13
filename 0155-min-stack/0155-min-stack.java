class MinStack {
    
    Stack<Integer> stack = new Stack();
    Stack<Integer> min_values = new Stack();
    
    public MinStack() {
        //Constructor not needed
    }
    
    public void push(int val) {
        if(min_values.isEmpty() || val <= min_values.peek()){
            min_values.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(min_values.peek().equals(stack.peek())){
            min_values.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return min_values.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */