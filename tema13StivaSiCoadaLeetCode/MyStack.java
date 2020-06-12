package tema13StivaSiCoadaLeetCode;

import java.util.Deque;
import java.util.LinkedList;

// Implement Stack using Queues

class MyStack {
   
    private Deque<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
       q.offer(x);
       for ( int i = 0; i < q.size() - 1; i++) {
          int val = q.poll();
          q.offer(val);
       }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
  
}
