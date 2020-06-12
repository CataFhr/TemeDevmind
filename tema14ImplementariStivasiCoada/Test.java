package tema14ImplementariStivasiCoada;

public class Test {

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		System.out.println(stack.isEmpty());
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack);
		System.out.println();
		
		MyQueue<Integer> queue = new MyQueue<>();
		System.out.println(queue.isEmpty());
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue.isEmpty());
		System.out.println(queue.peek());
		queue.poll();
		System.out.println(queue);
		System.out.println();
		
		MyStack1 stack1 = new MyStack1();
		System.out.println(stack1.isEmpty());
		stack1.push(5);
		stack1.push(6);
		stack1.push(7);
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1);
		System.out.println();
		
		MyQueue1 queue1 = new MyQueue1();
		System.out.println(queue1.isEmpty());
		queue1.offer(5);
		queue1.offer(6);
		queue1.offer(7);
		System.out.println(queue1.isEmpty());
		System.out.println(queue1.peek());
		queue1.poll();
		System.out.println(queue1);
	}
	
}
