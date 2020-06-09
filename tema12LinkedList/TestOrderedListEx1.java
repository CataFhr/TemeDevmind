package tema12LinkedList;

public class TestOrderedListEx1 {

	public static void main(String[] args) {
		Town t1 = new Town("Suceava", 450);
		Town t2 = new Town("Cluj", 400);
		Town t3 = new Town("Targu Jiu", 315);
		Town t4 = new Town("Bucuresti", 10);
		Town t5 = new Town("Brasov", 250);
		Town t6 = new Town("Bacau", 260);
		Town t7 = new Town("Suceava", 450);
		Town t8 = new Town("Bucuresti", 10);
		Town t9 = new Town("Brasov", 250);
		Town t10 = new Town("Brasov", 250);

		OrderedListEx1<Town> orderedTownsList = new OrderedListEx1<>();

		orderedTownsList.addInOrderedList(t1);
		orderedTownsList.addInOrderedList(t2);
		orderedTownsList.addInOrderedList(t3);
		orderedTownsList.addInOrderedList(t4);

		System.out.println(orderedTownsList);

		orderedTownsList.addInOrderedList(t5);
		orderedTownsList.addInOrderedList(t6);
		orderedTownsList.addInOrderedList(t7);
		orderedTownsList.addInOrderedList(t8);
		orderedTownsList.addInOrderedList(t9);
		orderedTownsList.addInOrderedList(t10);

		System.out.println(orderedTownsList);
	}
}
