package tema14ImplementariStivasiCoada;

// Implement queue using circular array

public class MyQueue1 {

	private static final int MAX = 1000;
	private int arr[];
	private int front;
	private int rear;

	public MyQueue1() {
		this.arr = new int[MyQueue1.MAX];
		this.front = -1;
		this.rear = -1;
	}

	public void offer(int val) {
		if ((this.front == 0 && this.rear == MyQueue1.MAX - 1) || this.front == this.rear + 1) {
			System.out.println("Queue is full");
			return;
		}
		if (this.front == -1) {
			this.front = 0;
			this.rear = 0;
		} else if (this.rear == MyQueue1.MAX - 1) {
			this.rear = 0;
		} else {
			this.rear++;
		}
		this.arr[this.rear] = val;
	}

	public int poll() {
		if (this.front == -1) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int value = this.arr[this.front];
		if (this.front == this.rear) {
			this.front = -1;
			this.rear = -1;
		} else if (this.front == MyQueue1.MAX - 1) {
			this.front = 0;
		} else {
			this.front++;
		}
		return value;
	}

	public int peek() {
		if (this.front == -1) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return this.arr[this.front];
	}

	public boolean isEmpty() {
		return this.front == -1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int i = this.front;
		while (i != this.rear) {
			sb.append(this.arr[i] + ",");
			i = (i + 1) % MyQueue1.MAX;
		}
		sb.append(this.arr[this.rear]);
		sb.append("]");
		return sb.toString();
	}

}
