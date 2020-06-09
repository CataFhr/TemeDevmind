package tema12LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OrderedListEx2 {

	private List<Integer> list = new LinkedList<>();

	public boolean addInOrderedList(int newElement) {
		ListIterator<Integer> li = list.listIterator();
		while (li.hasNext()) {
			int comparison = li.next().compareTo(newElement);

			if (comparison > 0) {
				li.previous();
				li.add(newElement);
				return true;
			}
		}
		li.add(newElement);
		return true;
	}

	public void removeDuplicates() {
		ListIterator<Integer> it = list.listIterator();
		int prev = 0;
		if (it.hasNext()) {
			prev = it.next();
		}
		while (it.hasNext()) {
			int current = it.next();
			if (prev == current) {
				it.remove();
			}
			prev = current;
		}
	}

	public void removeDuplicates2() {
		ListIterator<Integer> it = list.listIterator();
		int prev = 0;
		if (it.hasNext()) {
			prev = it.next();
		}
		while (it.hasNext()) {
			int current = it.next();
			if (prev == current) {
				it.remove();
				if (it.hasPrevious() && it.previous() == current) {
					it.remove();
				}
			}
			prev = current;
		}
	}

	@Override
	public String toString() {
		String ret = "";
		for (int el : list) {
			ret += el + "->";
		}
		ret += "null";
		return ret;
	}
}
