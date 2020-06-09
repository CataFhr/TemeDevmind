package tema12LinkedList;

public class TestOrderedListEx2 {

	public static void main(String[] args) {
		OrderedListEx2 orderedList = new OrderedListEx2();
		orderedList.addInOrderedList(2);
		orderedList.addInOrderedList(2);
		orderedList.addInOrderedList(1);
		orderedList.addInOrderedList(10);
		orderedList.addInOrderedList(9);
		orderedList.addInOrderedList(9);
		orderedList.addInOrderedList(2);

		System.out.println(orderedList);

//	    orderedList.removeDuplicates();
		orderedList.removeDuplicates2();

		System.out.println(orderedList);

	}

}
