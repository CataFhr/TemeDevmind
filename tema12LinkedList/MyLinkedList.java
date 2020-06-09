package tema12LinkedList;

public class MyLinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public MyLinkedList() {
		this.size = 0;
	}

	public MyLinkedList(MyLinkedList<E> c) {
		this();
		this.addAll(c);
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void addFirst(E elem) {
		Node<E> newNode = new Node<E>(elem);
		if (this.head == null) {
			this.head = newNode;
			this.tail = this.head;
		} else {
			this.head.prev = newNode;
			newNode.next = this.head;
			this.head = newNode;
		}
		this.size++;
	}

	public void addLast(E elem) {
		Node<E> newNode = new Node<E>(elem);
		if (this.head == null) {
			this.head = newNode;
			this.tail = this.head;
		} else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.size++;
	}

	public E removeFirst() {
		if (this.size == 0) {
			System.out.println("Exception: Empty List");
		}
		Node<E> tmp = this.head;
		this.head = this.head.next;
		this.head.prev = null;
		this.size--;
		return tmp.value;
	}

	public E removeLast() {
		if (this.size == 0) {
			System.out.println("Exception: Empty List");
		}
		Node<E> tmp = this.tail;
		this.tail = this.tail.prev;
		this.tail.next = null;
		this.size--;
		return tmp.value;
	}

	public void add(int index, E elem) {
		if (index < 0 || index > this.size) {
			System.out.println("IndexOutOfBoundsException");
			return;
		}
		if (index == this.size) {
			addLast(elem);
			return;
		}
		if (index == 0) {
			addFirst(elem);
			return;
		}
		Node<E> it = this.head;
		for (int i = 0; i < index - 1; i++) {
			it = it.next;
		}
		Node<E> newNode = new Node<E>(elem);
		newNode.next = it.next;
		newNode.prev = it;
		it.next.prev = newNode;
		it.next = newNode;
		this.size++;
	}

	public boolean add(E elem) {
		this.addLast(elem);
		return true;
	}

	public E removeElementAtIndex(int index) {
		if (index < 0 || index > this.size) {
			System.out.println("IndexOutOfBoundsException");
			return null;
		}
		if (index == this.size - 1) {
			return removeLast();
		}
		if (index == 0) {
			return removeFirst();
		}
		Node<E> it = this.head;
		for (int i = 0; i < index -1 ; i++) {
			it = it.next;
		}
		Node<E> temp = it.next;
		it.next = it.next.next;
		it.next.prev = it;
		temp.next = null;
		temp.prev = null;
		this.size--;
		return temp.value;
	}

	public boolean remove(E elem) {
		int index = this.indexOf(elem);
		if (index < 0) {
			return false;
		}
		this.removeElementAtIndex(index);
		return true;
	}

	public int indexOf(E elem) {
		int index = 0;
		Node<E> it = this.head;
		while (it != null) {
			if (it.value.equals(elem)) {
				return index;
			}
			index++;
			it = it.next;
		}
		return -1;
	}

	public int lastIndexOf(E elem) {
		int index = this.size - 1;
		Node<E> it = this.tail;
		while (it != null) {
			if (it.value.equals(elem)) {
				return index;
			}
			index--;
			it = it.prev;
		}
		return -1;
	}

	public boolean contains(E elem) {
		return this.indexOf(elem) > 0;
	}

	public E get(int index) {
		if (index < 0 || index > this.size) {
			System.out.println("IndexOutOfBoundsException");
			return null;
		}
		if (index == 0) {
			return this.head.value;
		}
		if (index == this.size - 1) {
			return this.tail.value;
		}
		Node<E> it = this.head;
		for (int i = 0; i < index; i++) {
			it = it.next;
		}
		return it.value;
	}

	public boolean addAll(int index, MyLinkedList<E> c) {
		if (c.size() == 0) {
			return false;
		}
		if (index < 0 || index > this.size) {
			System.out.println("IndexOutOfBoundsException");
			return false;
		}
		Node<E> cIt = c.head;
		while (cIt != null) {
			this.add(index, cIt.value);
			index++;
			cIt = cIt.next;
		}
		return true;
	}

	public boolean addAll(MyLinkedList<E> c) {
		return this.addAll(this.size, c);
	}

	public E set(int index, E elem) {
		if (index < 0 || index >= this.size) {
			System.out.println("IndexOutOfBoundsException");
			return null;
		}
		Node<E> it = this.head;
		for (int i = 0; i < index; i++) {
			it = it.next;
		}
		E oldVal = it.value;
		it.value = elem;
		return oldVal;
	}

	public void clear() {
		Node<E> it = this.head;
		while (it.next != null) {
			Node<E> next = it.next;
			it.value = null;
			it.next = null;
			it.prev = null;
			it = next;
		}
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Object[] toArray() {
		Object[] result = new Object[size];
		int index = 0;
		Node<E> it = this.head;
		while (it != null) {
			result[index] = it.value;
			index++;
		}
		return result;
	}

	public void iterateForward() {
		System.out.println("iterating forward...");
		Node<E> it = this.head;
		while (it != null) {
			System.out.print(it.value + " ");
			it = it.next;
		}
		System.out.println();
	}

	public void iterateBackward() {
		System.out.println("iterating backword...");
		Node<E> it = this.tail;
		while (it != null) {
			System.out.print(it.value + " ");
			it = it.prev;
		}
		System.out.println();
	}

	private class Node<E> {

		private E value;
		private Node<E> next;
		private Node<E> prev;

		public Node(E value, Node<E> next, Node<E> previous) {
			this.value = value;
			this.next = next;
			this.prev = previous;
		}

		public Node(E value) {
			this(value, null, null);
		}
	}

}
