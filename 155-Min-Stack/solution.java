public class MinStack {
    
    // time: O(1),use one stack
    int min = Integer.MAX_VALUE;
    
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(min >= x){           //must include "=" here
            stack.push(min);    //push both x and oldmin if min changes
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.isEmpty()){min = Integer.MAX_VALUE;return;};
        if(top() == min){
            stack.pop();
            min = stack.peek();
            stack.pop();
        }
        else stack.pop();
    }
    
    public int top() {
         if(stack.isEmpty())return 0;
        else return stack.peek();
    }
    
    public int getMin() { 
        return min;
        //must recover the stack after find min
        // int min = top();
        // Stack<Integer> temp = new Stack<Integer>();
        // temp.push(top());
        // pop();
        // while(!stack.isEmpty()){
        //     if(top() < min){
        //         min = top();
        //     }
        //     temp.push(top());
        //     pop();
        // }
        // while(!temp.isEmpty()){
        //     push(temp.pop());
        // }
        // return min;
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