package tema15Dictionare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode {

	// Ex1 Valid Anagram

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Integer> map1 = generate(s);
		HashMap<Character, Integer> map2 = generate(t);
		return map1.equals(map2);
	}

	private HashMap<Character, Integer> generate(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				int count = map.get(str.charAt(i));
				count++;
				map.put(str.charAt(i), count);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		return map;
	}

	// Ex2 Two Sum

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
			}
			map.put((nums[i]), i);
		}
		return result;
	}

	// Ex3 Longest Substring Without Repeating Characters

	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		Set<Character> set = new HashSet<>();
		int start = 0; // pozitia din string a primului caracter din set
		int i = 0; // elem curent din string
		int max = 0;
		while (i < s.length()) {
			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i));
				i++;
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(start));
				start++;
			}
		}
		return max;
	}

	// Ex4 First Unique Character in a String

	public int firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int count = map.get(s.charAt(i));
				count++;
				map.put(s.charAt(i), count);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	// Ex5 Longest Palindrome

	public int longestPalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int count = map.get(s.charAt(i));
				count++;
				map.put(s.charAt(i), count);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		int count = 0;
		for (char k : map.keySet()) {
			if (map.get(k) >= 2 && map.get(k) % 2 == 0) {
				count += map.get(k);
			} else if (map.get(k) >= 2) {
				count += map.get(k) - 1;
			}
		}
		return Math.min(count + 1, s.length());
	}

	// Ex6 Minimum Index Sum of Two Lists

	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		List<String> list = new ArrayList<>();
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				int sum = i + map.get(list2[i]);
				if (sum < minSum) {
					minSum = sum;
					list.clear();
					list.add(list2[i]);
				} else if (sum == minSum) {
					list.add(list2[i]);
				}
			}
		}
		String[] result = new String[list.size()];
		return list.toArray(result);
	}

	// Ex7 Intersection of Two Arrays II

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				int count = map.get(nums1[i]);
				count++;
				map.put(nums1[i], count);
			} else {
				map.put(nums1[i], 1);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
				list.add(nums2[i]);
				int count = map.get(nums2[i]);
				count--;
				map.put(nums2[i], count);
			}
		}
		int[] result = new int[list.size()];
		int index = 0;
		for (int num : list) {
			result[index++] = num;
		}
		return result;
	}

	// Ex8 Design HashMap
	
	class MyHashMap {

		private int[] arr;

		/** Initialize your data structure here. */
		public MyHashMap() {
			arr = new int[1000000];
			//Arrays.fill(arr, -1);
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			arr[key] = value + 1;
		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map
		 * contains no mapping for the key
		 */
		public int get(int key) {
			return arr[key] - 1;
		}

		/**
		 * Removes the mapping of the specified value key if this map contains a mapping
		 * for the key
		 */
		public void remove(int key) {
			arr[key] = 0;
		}
	}
}
