class MyStack {
    Queue<Integer> q = new LinkedList<Integer>(); 
    Queue<Integer> p = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        while(!q.isEmpty()){
            p.add(q.remove());
        }
        q.add(x);
        while(!p.isEmpty()){
            q.add(p.remove());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.remove();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}