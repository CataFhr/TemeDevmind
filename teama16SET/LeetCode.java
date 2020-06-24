package teama16SET;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode {

	// Ex1 - Single Number

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
		for (Integer elem : set) {
			return elem;
		}
		return -1;
	}

	// Ex2 - Jewels and Stones

	public int numJewelsInStones(String J, String S) {
		int count = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < J.length(); i++) {
			set.add(J.charAt(i));
		}
		for (int i = 0; i < S.length(); i++) {
			if (set.contains(S.charAt(i))) {
				count++;
			}
		}
		return count;
	}

	// Ex3 - Intersection of Two Arrays

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> setResult = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i])) {
				setResult.add(nums2[i]);
			}
		}
		int index = 0;
		int[] result = new int[setResult.size()];
		for (int elem : setResult) {
			result[index] = elem;
			index++;
		}
		return result;
	}

	// Ex4 - Keyboard Row

	public String[] findWords(String[] words) {
		String[] result = new String[words.length];
		Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
		Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
		Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
		int index = 0;
		for (int i = 0; i < words.length; i++) {
			if (containsOnly(words[i].toLowerCase(), set1) || containsOnly(words[i].toLowerCase(), set2)
					|| containsOnly(words[i].toLowerCase(), set3)) {
				result[index] = words[i];
				index++;
			}
		}
		result = Arrays.copyOf(result, index);
		return result;
	}

	private boolean containsOnly(String s1, Set<Character> set) {
		for (int i = 0; i < s1.length(); i++) {
			if (!set.contains(s1.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// Ex5 - Distribute Candies

	public int distributeCandies(int[] candies) {
		HashSet<Integer> set = new HashSet<>();
		for (int candy : candies) {
			set.add(candy);
		}
		return Math.min(set.size(), candies.length / 2);
	}

	// Ex6 - Contains Duplicate

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int number : nums) {
			// if (set.contains(number)) {
			// return true;
			// }
			set.add(number);
		}
		// return false;
		return set.size() != nums.length;
	}

}
