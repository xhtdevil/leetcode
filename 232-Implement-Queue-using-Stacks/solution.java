class MyQueue {
    // List<Integer> Stack = new ArrayList<Integer>;
    // private void pushStack(int x){
    //     Stack.add(x);
    // }
    // private int pop(){
    //     Stack.remove(list.size() - 1);
    // }
    Stack<Integer> sa = new Stack<Integer>();
    Stack<Integer> sb = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        while(!sa.isEmpty()){
            sb.push(sa.pop()); 
        }
        sa.push(x);
        while(!sb.isEmpty()){
            sa.push(sb.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        sa.pop();
    }

    // Get the front element.
    public int peek() {
        int x = sa.pop();
        return x;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return sa.isEmpty();
    }
}