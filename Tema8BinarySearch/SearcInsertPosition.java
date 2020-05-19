package Tema8BinarySearch;

public class SearcInsertPosition {

	public static int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start; // sau return end+1;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 6 };
		int target1 = 5;
		int[] arr2 = { 1, 3, 5, 6 };
		int target2 = 2;
		int[] arr3 = { 1, 2, 3, 6, 7, 9 };
		int target3 = 8;
		int[] arr4 = { 1, 2, 3, 6, 7, 9 };
		int target4 = 10;
		int[] arr5 = { 1, 2, 3, 6, 7, 9 };
		int target5 = -1;
		System.out.println(searchInsert(arr1, target1));
		System.out.println(searchInsert(arr2, target2));
		System.out.println(searchInsert(arr3, target3));
		System.out.println(searchInsert(arr4, target4));
		System.out.println(searchInsert(arr5, target5));
	}
}
