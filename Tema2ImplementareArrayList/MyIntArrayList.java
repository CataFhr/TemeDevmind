package Tema2ImplementareArrayList;

import java.util.Arrays;

public class MyIntArrayList {

	private int[] array;
	private int size;

	public MyIntArrayList() {
		this(10);
	}

	public MyIntArrayList(int initialCapacity) {
		this.array = new int[initialCapacity];
	}

	public MyIntArrayList(MyIntArrayList arr) {
		array = Arrays.copyOf(arr.array, arr.size);
		size = arr.size;
	}

	public void add(int index, int element) {

		if (index < 0 || index > size) {
			System.out.println("IndexOutOfBoundsException");
			return;
		}
		if (this.size == this.array.length) {
			this.array = Arrays.copyOf(this.array, this.size * 2);
		}

		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = element;
		this.size++;

	}

	public boolean add(int element) {
		add(size, element);
		return true;
	}

	public boolean contains(int element) {
		for (int i = 0; i < this.size; i++) {
			if (this.array[i] == element) {
				return true;
			}
		}
		return false;

	}

	public int size() {
		return this.size;
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			System.out.println("IndexOutOfBoundsException");
			return -9999;
		}
		return array[index];
	}

	public int indexOf(int e) {
		for (int i = 0; i < this.size; i++) {
			if (this.array[i] == e) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(int e) {
		for (int i = size - 1; i >= 0; i--) {
			if (this.array[i] == e) {
				return i;
			}
		}
		return -1;
	}

	public int removeElementAtIndex(int index) {
		if (index < 0 || index >= this.size) {
			// should throw IndexOutOfBoundsException
			System.out.println(
					"Throwing IndexOutOfBoundsException when trying to" + " remove element at position " + index);
			return -1;
		}

		int removedElement = this.array[index];
		for (int i = index; i < this.size - 1; i++) {
			this.array[i] = this.array[i + 1];
		}
		this.size--;

		return removedElement;
	}

	public boolean removeElement(int element) {
		int index = indexOf(element);
		removeElementAtIndex(index);
		return true;
	}

	public void clear() {
		this.size = 0;
		// array = new int[10];
	}

	public int set(int index, int e) {
		if (index < 0 || index >= this.size) {
			// should throw IndexOutOfBoundsException
			System.out.println("Throwing IndexOutOfBoundsException when trying to set" + " the element " + e
					+ " at position " + index);
			return -1;
		}

		int replacedElement = this.array[index];
		this.array[index] = e;
		return replacedElement;
	}

	public boolean addAll(int index, MyIntArrayList arr) {
		for (int i = 0; i < arr.size; i++) {
			add(index, arr.get(i));
			index++;
		}

		return true;
	}

	public boolean addAll(MyIntArrayList arr) {
		return addAll(size, arr);
	}

	public int[] toArray() {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = get(i);
		}
		// return Arrays.copyOf(array, size);
		return arr;
	}

	public void ensureCapacity(int minCapacity) {
		array = Arrays.copyOf(array, minCapacity);
	}

	public void trimToSize() {
		array = Arrays.copyOf(array, size);
	}
	
	

	public static void main(String[] args) {

		MyIntArrayList list = new MyIntArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list.size());
		System.out.println(list.contains(10));
		System.out.println(list.indexOf(2));

		list.removeElementAtIndex(1);
		list.set(0, 100);
		// list.clear();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();

		MyIntArrayList list2 = new MyIntArrayList();
		list2.add(7);
		list2.add(8);
		list2.add(9);

		list.addAll(list2);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

}
