package tema13StivaSiCoadaLeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

	private Deque<Integer> stack;
	private static int min = Integer.MAX_VALUE;

	public MinStack() {
		stack = new LinkedList<>();
	}

	public void push(int x) {
		stack.push(x);
		if (x <= min) {
			min = x;
		}
		stack.push(min);
	}

	public void pop() {
		stack.pop();
		stack.pop();
		if (stack.size() == 0) {
			min = Integer.MAX_VALUE;
		} else {
			min = stack.peek();
		}

	}

	public int top() {
		min = stack.pop();
		int top = stack.peek();
		stack.push(min);
		return top;
	}

	public int getMin() {
		return min;
		// return stack.peek();
	}
}
