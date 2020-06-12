package tema13StivaSiCoadaLeetCode;

import java.util.Deque;
import java.util.LinkedList;

// Implement Queue using Stacks

class MyQueue {
    
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    
    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }
    
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
 
}

