package tema13StivaSiCoadaLeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class RadixSort {

	static Deque<Integer> q0 = new LinkedList<>();
	static Deque<Integer> q1 = new LinkedList<>();
	static Deque<Integer> q2 = new LinkedList<>();
	static Deque<Integer> q3 = new LinkedList<>();
	static Deque<Integer> q4 = new LinkedList<>();
	static Deque<Integer> q5 = new LinkedList<>();
	static Deque<Integer> q6 = new LinkedList<>();
	static Deque<Integer> q7 = new LinkedList<>();
	static Deque<Integer> q8 = new LinkedList<>();
	static Deque<Integer> q9 = new LinkedList<>();

	public static Integer[] sortAscending(Integer[] arr) {
		int max = Collections.max(Arrays.asList(arr));
//		int max = Arrays.stream(arr).max().getAsInt(); -pt int 

		int maxDigitsNo = countDigitsNo(max);
		int n = 1;
		for (int k = 0; k < maxDigitsNo; k++) {
			for (int i = 0; i < arr.length; i++) {
				switch (arr[i] / n % 10) {
				case 0:
					q0.offer(arr[i]);
					break;
				case 1:
					q1.offer(arr[i]);
					break;
				case 2:
					q2.offer(arr[i]);
					break;
				case 3:
					q3.offer(arr[i]);
					break;
				case 4:
					q4.offer(arr[i]);
					break;
				case 5:
					q5.offer(arr[i]);
					break;
				case 6:
					q6.offer(arr[i]);
					break;
				case 7:
					q7.offer(arr[i]);
					break;
				case 8:
					q8.offer(arr[i]);
					break;
				case 9:
					q9.offer(arr[i]);
					break;
				}
			}
			n *= 10;
			int index = 0;
			while (!q0.isEmpty()) {
				arr[index] = q0.pop();
				index++;
			}
			while (!q1.isEmpty()) {
				arr[index] = q1.pop();
				index++;
			}
			while (!q2.isEmpty()) {
				arr[index] = q2.pop();
				index++;
			}
			while (!q3.isEmpty()) {
				arr[index] = q3.pop();
				index++;
			}
			while (!q4.isEmpty()) {
				arr[index] = q4.pop();
				index++;
			}
			while (!q5.isEmpty()) {
				arr[index] = q5.pop();
				index++;
			}
			while (!q6.isEmpty()) {
				arr[index] = q6.pop();
				index++;
			}
			while (!q7.isEmpty()) {
				arr[index] = q7.pop();
				index++;
			}
			while (!q8.isEmpty()) {
				arr[index] = q8.pop();
				index++;
			}
			while (!q9.isEmpty()) {
				arr[index] = q9.pop();
				index++;
			}
			// System.out.println(Arrays.toString(arr));
		}
		return arr;
	}

	public static Integer[] sortDescending(Integer[] arr) {
		int max = Collections.max(Arrays.asList(arr));

		int maxDigitsNo = countDigitsNo(max);
		int n = 1;
		for (int k = 0; k < maxDigitsNo; k++) {
			for (int i = 0; i < arr.length; i++) {
				switch (arr[i] / n % 10) {
				case 0:
					q0.offer(arr[i]);
					break;
				case 1:
					q1.offer(arr[i]);
					break;
				case 2:
					q2.offer(arr[i]);
					break;
				case 3:
					q3.offer(arr[i]);
					break;
				case 4:
					q4.offer(arr[i]);
					break;
				case 5:
					q5.offer(arr[i]);
					break;
				case 6:
					q6.offer(arr[i]);
					break;
				case 7:
					q7.offer(arr[i]);
					break;
				case 8:
					q8.offer(arr[i]);
					break;
				case 9:
					q9.offer(arr[i]);
					break;
				}
			}
			n *= 10;
			int index = 0;
			while (!q9.isEmpty()) {
				arr[index] = q9.pop();
				index++;
			}
			while (!q8.isEmpty()) {
				arr[index] = q8.pop();
				index++;
			}
			while (!q7.isEmpty()) {
				arr[index] = q7.pop();
				index++;
			}
			while (!q6.isEmpty()) {
				arr[index] = q6.pop();
				index++;
			}
			while (!q5.isEmpty()) {
				arr[index] = q5.pop();
				index++;
			}
			while (!q4.isEmpty()) {
				arr[index] = q4.pop();
				index++;
			}
			while (!q3.isEmpty()) {
				arr[index] = q3.pop();
				index++;
			}
			while (!q2.isEmpty()) {
				arr[index] = q2.pop();
				index++;
			}
			while (!q1.isEmpty()) {
				arr[index] = q1.pop();
				index++;
			}
			while (!q0.isEmpty()) {
				arr[index] = q0.pop();
				index++;
			}
		}
		return arr;
	}

	private static int countDigitsNo(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		Integer[] array = { 1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713 };
		System.out.println(Arrays.toString(sortAscending(array)));
		System.out.println(Arrays.toString(sortDescending(array)));
	}

}
