package tema9LeetCodeBinarySearch;

public class SearchInRotatedSortedArray {

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int pivot = findPivot(nums);
		if (pivot == -1) {
			return binarySearch(nums, 0, nums.length - 1, target);
		} else if (nums[pivot] == target) {
			return pivot;
		} else if (nums[0] > target) {
			return binarySearch(nums, pivot + 1, nums.length - 1, target);
		} else {
			return binarySearch(nums, 0, pivot - 1, target);
		}
	}

	private static int findPivot(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = (end + start) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return mid + 1;
			} else if (nums[mid] >= nums[start]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] nums, int start, int end, int target) {
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
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		int target1 = 3;
		System.out.println(search(array, target));
		System.out.println(search(array, target1));
	}

}
