package tema14ImplementariStivasiCoada;

// Implement stack using LinkedList (double-linked list)

public class MyStack<E> {
	
	private MyLinkedList<E> list;
	
	public MyStack() {
		list = new MyLinkedList<>();
	}
	
	public void push(E elem) {
		this.list.addFirst(elem);
	}
	
	public E pop() {
		return this.list.removeFirst();
	}
	
	public E peek() {
		return this.list.get(0);
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public String toString() {
		return this.list.toString();
	}
	
}
