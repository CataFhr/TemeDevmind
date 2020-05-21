package tema9LeetCodeBinarySearch;

public class ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		long start = 2;
		long end = num / 2;
		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));
		System.out.println(isPerfectSquare(14));
	}

}
