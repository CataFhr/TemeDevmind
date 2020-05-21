package tema9LeetCodeBinarySearch;

public class Sqrt {

	public static int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		long start = 1;
		long end = x;
		long res = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid < x) {
				start = mid + 1;
				res = mid;
			} else {
				end = mid - 1;
			}
		}
		return (int) res;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(26));
	}

}
