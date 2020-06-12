package tema14ImplementariStivasiCoada;

// Implement stack using array

public class MyStack1 {

	private static final int MAX = 1000;
	private int top;
	private int arr[];

	public MyStack1() {
		this.top = -1;
		this.arr = new int[MyStack1.MAX];
	}

	public void push(int val) {
		if (this.top >= (MyStack1.MAX - 1)) {
			System.out.println("Stack is full");
			return;
		}
		this.top++;
		this.arr[this.top] = val;
	}

	public int pop() {
		if (this.top < 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int value = this.arr[this.top];
		top--;
		return value;
	}

	public int peek() {
		if (this.top < 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return this.arr[this.top];
	}

	public boolean isEmpty() {
		return this.top < 0;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = top; i >= 0; i--) {
			sb.append(this.arr[i]);
			if (i > 0) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
