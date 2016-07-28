public class MinStack {
    // notice the 
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public void pop() {
        if(stack.isEmpty())return;
        else stack.pop();
    }
    
    public int top() {
         if(stack.isEmpty())return -10000;
        else return stack.peek();
    }
    
    public int getMin() {               //must recover the stack after find min
        int min = top();
        Stack<Integer> temp = new Stack<Integer>();
        temp.push(top());
        pop();
        while(!stack.isEmpty()){
            if(top() < min){
                min = top();
            }
            temp.push(top());
            pop();
        }
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */