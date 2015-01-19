class MinStack {
    Stack<Integer> nums = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int x) {
        nums.push(x);
        min = mins.empty() ? x : Math.min(mins.peek(), x);
        mins.push(min);
    }

    public void pop() {
        try {
            nums.pop();
            mins.pop();
        }
        catch(Exception e) {
            
        }
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
