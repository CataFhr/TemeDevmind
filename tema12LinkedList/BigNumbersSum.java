package tema12LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class BigNumbersSum {

	public static LinkedList<Integer> sum(LinkedList<Integer> list1, LinkedList<Integer> list2) {

		// Varianta1 - fara o lista suplimentara

		ListIterator<Integer> it1 = list1.listIterator();
		ListIterator<Integer> it2 = list2.listIterator();
		while (it1.hasNext()) {
			it1.next();
		}
		while (it2.hasNext()) {
			it2.next();
		}
		int reminder = 0;
		while (it1.hasPrevious() && it2.hasPrevious()) {
			int sum = it1.previous() + it2.previous() + reminder;
			it1.set(sum % 10);
			reminder = sum / 10;
		}
		if (it1.hasPrevious()) {
			while (it1.hasPrevious()) {
				int sum = it1.previous() + reminder;
				it1.set(sum % 10);
				reminder = sum / 10;
			}
		} else if (it2.hasPrevious()) {
			while (it2.hasPrevious()) {
				int sum = it2.previous() + reminder;
				list1.addFirst(sum % 10);
				reminder = sum / 10;
			}
		}
		if (reminder != 0) {
			list1.addFirst(reminder);
		}
		return list1;

		// Varianta2 - folosind o lista suplimentara

//		LinkedList<Integer> result = new LinkedList<>();
//		ListIterator<Integer> it1 = list1.listIterator();
//		ListIterator<Integer> it2 = list2.listIterator();
//		while (it1.hasNext()) {
//			it1.next();
//		}
//		while (it2.hasNext()) {
//			it2.next();
//		}
//		int reminder = 0;
//		while (it1.hasPrevious() && it2.hasPrevious()) {
//			int sum = it1.previous() + it2.previous() + reminder;
//			result.addFirst(sum % 10);
//			reminder = sum / 10;
//		}
//
//		while (it1.hasPrevious()) {
//			int sum = it1.previous() + reminder;
//			result.addFirst(sum % 10);
//			reminder = sum / 10;
//		}
//		while (it2.hasPrevious()) {
//			int sum = it2.previous() + reminder;
//			result.addFirst(sum % 10);
//			reminder = sum / 10;
//		}
//		if (reminder != 0) {
//			result.addFirst(reminder);
//		}
//		return result;
	}

	public static void main(String[] args) {

		LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(2, 1, 7, 8));
		LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(5, 9, 6));
		LinkedList<Integer> result = sum(list1, list2);
		System.out.println(result);
	}

}
