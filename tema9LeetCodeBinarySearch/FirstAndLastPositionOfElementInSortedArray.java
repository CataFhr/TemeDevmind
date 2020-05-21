package tema9LeetCodeBinarySearch;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	private static int findLast(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int index = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				index = mid;
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return index;
	}

	private static int findFirst(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int index = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				index = mid;
				end = mid - 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] array = { 5, 7, 7, 8, 8, 8, 10 };
		int target = 8;
		int target1 = 6;
		System.out.println(Arrays.toString(searchRange(array, target)));
		System.out.println(Arrays.toString(searchRange(array, target1)));
	}

}
