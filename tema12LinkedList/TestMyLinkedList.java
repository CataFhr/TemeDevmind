package tema12LinkedList;

public class TestMyLinkedList {

	public static void main(String[] args) {
		
		MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
		list1.add(2);
		list1.addFirst(1);
		list1.add(3);
		list1.add(4);
		list1.addLast(6);
		list1.add(4,5);
		list1.iterateBackward();
		list1.iterateForward();
		
		MyLinkedList<Integer> list = new MyLinkedList<Integer>(list1);
		list.iterateForward();
		list.add(7);
		list.add(8);
		list.add(9);
		//list.iterateForward();
		//list.addAll(2, list1);
		list.iterateForward();
		System.out.println(list.size());
		list.remove(9); 
		list.removeElementAtIndex(1); 
		list.removeLast();
		list.removeFirst();
		list.add(5);
		list.iterateForward();
		list.set(1, 100);
		list.iterateForward();
		
		System.out.println(list.size());
		System.out.println(list.indexOf(5));
		System.out.println(list.lastIndexOf(5));
		System.out.println(list.get(4));
		list.clear();
		System.out.println(list.isEmpty());
		list.iterateForward();
		
	}

}
