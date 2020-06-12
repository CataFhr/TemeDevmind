package tema14ImplementariStivasiCoada;

//Implement queue using LinkedList (double-linked list)

public class MyQueue<E> {

	private MyLinkedList<E> list;

	public MyQueue() {
		list = new MyLinkedList<>();
	}

	public void offer(E elem) {
		this.list.addLast(elem);
	}

	public E poll() {
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
