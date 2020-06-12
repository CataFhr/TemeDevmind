package tema13StivaSiCoadaLeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class BaseballGame {

	public int calPoints(String[] ops) {

		Deque<Integer> stack = new LinkedList<>();
		int sum = 0;

		for (int i = 0; i < ops.length; i++) {
			if (ops[i].equals("D")) {
				int point = stack.peek() * 2;
				stack.push(point);
				sum += point;
			} else if (ops[i].equals("C")) {
				int lastValue = stack.pop();
				sum -= lastValue;
			} else if (ops[i].equals("+")) {
				int val1 = 0;
				int val2 = 0;
				if (stack.size() > 1) {
					val1 = stack.pop();
					val2 = stack.pop();
				} else if (stack.size() > 0) {
					val1 = stack.pop();
				}
				int point = val1 + val2;
				stack.push(val2);
				stack.push(val1);
				stack.push(point);
				sum += point;
			} else {
				int point = Integer.valueOf(ops[i]);
				stack.push(point);
				sum += point;
			}
		}
		return sum;
	}
}
