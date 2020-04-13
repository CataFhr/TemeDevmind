package Tema1Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;

public class Exercitiul1 {

//	private static int numarAparitii(int element, ArrayList<Integer> list) {
//		int count = 0;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) == element) {
//				count++;
//			}
//		}
//		return count;
//	}
//
//	
//	public static ArrayList<Integer> printElementeCuFrecventaMaxima(ArrayList<Integer> list) {
//		
//		ArrayList<Integer> newList = new ArrayList<Integer>();
//		int max = Integer.MIN_VALUE;
//		for (int i = 0; i < list.size(); i++) {
//			int element = list.get(i);
//			int counter = numarAparitii(element, list);
//			if (counter > max) {
//				max = counter;
//			}
//		}
//		for (int i = 0; i < list.size(); i++) {
//			int element = list.get(i);
//			int counter = numarAparitii(element, list);
//			if (counter == max && newList.indexOf(element) < 0) {
//				newList.add(element);
//			}
//		}
//		return newList;
//	}

	
	// Varianta 1 - parametru un ArrayList(folosind un singur for)

	public static ArrayList<Integer> printElementeCuFrecventaMaxima(ArrayList<Integer> list) {

		ArrayList<Integer> newList = new ArrayList<Integer>();
		Collections.sort(list);
		int count = 1;
		int max = 1;
		int current = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (current == list.get(i)) {
				count++;
			} else {
				if (count > max) {
					max = count;
					newList.clear();
					newList.add(current);
				} else if (count == max) {
					newList.add(current);
				}

				current = list.get(i);
				count = 1;
			}
		}
		return newList;
	}

	
	// Varianta 2 - parametru un String

	public static ArrayList<Character> chCuAparitiiMaxime(String s) {
		ArrayList<Character> list = new ArrayList<Character>();

		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			int counter = nrAparitii(s, s.charAt(i));

			if (counter > max && !Character.isWhitespace(s.charAt(i))
					&& nrAparitii(s.substring(i + 1, s.length()), s.charAt(i)) == 0) {
				max = counter;
				list.clear();
				list.add(s.charAt(i));
			} else if (counter == max && !Character.isWhitespace(s.charAt(i))
					&& nrAparitii(s.substring(i + 1, s.length()), s.charAt(i)) == 0) {
				list.add(s.charAt(i));
			}
		}
		return list;

	}

	private static int nrAparitii(String s, char ch) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		// Varianta 1 - parametru un ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(7, 2, 7, 11, 1, 3, 7, 5, 3, 2, 3));
		ArrayList<Integer> result = printElementeCuFrecventaMaxima(list);
		System.out.println(result);

		// Varianta 2 - parametru un String
		String s = "Becoming a programmer is like gaining super powers!";
		// String s = "Simple sentence.";
		ArrayList<Character> listCh = chCuAparitiiMaxime(s);
		System.out.println(listCh);

	}

}
