package tema12LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Bonus {

	// Merge two sorted list
	public static List<Integer> mergeTwoSortedList(List<Integer> list1, List<Integer> list2) {
		LinkedList<Integer> result = new LinkedList<>();
		ListIterator<Integer> it1 = list1.listIterator();
		ListIterator<Integer> it2 = list2.listIterator();

		while (it1.hasNext() && it2.hasNext()) {
			int elem1 = it1.next();
			int elem2 = it2.next();
			if (elem1 == elem2) {
				result.add(elem1);
				result.add(elem2);
			} else if (elem1 < elem2) {
				result.add(elem1);
				if (it2.hasPrevious()) {
					it2.previous();
				}
			} else {
				result.add(elem2);
				if (it1.hasPrevious()) {
					it1.previous();
				}
			}
		}
		while (it1.hasNext()) {
			result.add(it1.next());
		}
		while (it2.hasNext()) {
			result.add(it2.next());
		}

		return result;
	}

	// Rotate list
	public static LinkedList<Integer> rotateList(LinkedList<Integer> list, int k) {
		int size = list.size();
		for (int i = 0; i < k % size; i++) {
			list.addFirst(list.removeLast());
		}
		return list;
	}

	// Varianta2 - folosind o lista generica
	public static List<Integer> rotateList2(List<Integer> list, int k) {
		int size = list.size();
		ListIterator<Integer> it = list.listIterator();
		for (int i = 0; i < k % size; i++) {
			int lastElem = list.get(size - 1);
			it.add(lastElem);
		}
		for (int i = 0; i < k; i++) {
			list.remove(size);
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2, 4, 5, 6);
		System.out.println(l1);
		List<Integer> l2 = Arrays.asList(1, 4, 8, 9);
		System.out.println(l2);
		List<Integer> result = mergeTwoSortedList(l1, l2);
		System.out.println(result);

		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(list);
		list = rotateList(list, 2);
		System.out.println(list);

		result = rotateList2(result, 2);
		System.out.println(result);
	}

}
