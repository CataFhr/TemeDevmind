package tema18IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {

		try (Scanner sc1 = new Scanner(new BufferedReader(new FileReader("TemeDevmind/tema18IO/Numbers1.txt")));
				Scanner sc2 = new Scanner(new BufferedReader(new FileReader("TemeDevmind/tema18IO/Numbers2.txt")));
				BufferedWriter bw = new BufferedWriter(new FileWriter("TemeDevmind/tema18IO/NumbersMerge.txt"))) {
			
			int nums1 = 0;
			int nums2 = 0;
			if (!sc1.hasNext()) {
				while (sc2.hasNext()) {
					nums2 = Integer.parseInt(sc2.next().trim());
					bw.write(nums2 + " ");
				}
			} else if (!sc2.hasNext()) {
				while (sc1.hasNext()) {
					nums1 = Integer.parseInt(sc1.next().trim());
					bw.write(nums1 + " ");
				}
			}
			boolean goNext1 = true;
			boolean goNext2 = true;
			while (sc1.hasNext() && sc2.hasNext()) {
				if (goNext1) {
					nums1 = Integer.parseInt(sc1.next().trim());
				}
				if (goNext2) {
					nums2 = Integer.parseInt(sc2.next().trim());
				}

				if (nums1 < nums2) {
					bw.write(nums1 + " ");
					goNext1 = true;
					goNext2 = false;
				} else {
					bw.write(nums2 + " ");
					goNext2 = true;
					goNext1 = false;
				}
			}

			while (sc1.hasNext()) {
				nums1 = Integer.parseInt(sc1.next().trim());
				if (nums2 < nums1) {
					bw.write(nums2 + " ");
					nums2 = Integer.MAX_VALUE;
					bw.write(nums1 + " ");
				} else {
					bw.write(nums1 + " ");
					if (!sc1.hasNext() && nums1 != Integer.MAX_VALUE) {
						bw.write(nums2 + " ");
					}
				}
			}

			while (sc2.hasNext()) {
				if (goNext1) {
					bw.write(nums2 + " ");
					nums1 = Integer.MAX_VALUE;
				}
				nums2 = Integer.parseInt(sc2.next().trim());
				if (nums1 < nums2) {
					bw.write(nums1 + " ");
					nums1 = Integer.MAX_VALUE;
					bw.write(nums2 + " ");
				} else {
					bw.write(nums2 + " ");
					if (!sc2.hasNext() && nums1 != Integer.MAX_VALUE) {
						bw.write(nums1 + " ");
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

//		try (Scanner sc1 = new Scanner(new BufferedReader(new FileReader("TemeDevmind/tema18IO/Numbers1.txt")));
//				Scanner sc2 = new Scanner(new BufferedReader(new FileReader("TemeDevmind/tema18IO/Numbers2.txt")));
//				BufferedWriter bw = new BufferedWriter(new FileWriter("TemeDevmind/tema18IO/NumbersMerge.txt"))) {
//			int nums1 = 0;
//			int nums2 = 0;
//			boolean goNext1 = true;
//			boolean goNext2 = true;
//			while (sc1.hasNext() && sc2.hasNext()) {
//				if (goNext1) {
//					nums1 = Integer.parseInt(sc1.next().trim());
//				}
//				if (goNext2) {
//					nums2 = Integer.parseInt(sc2.next().trim());
//				}
//
//				if (nums1 < nums2) {
//					bw.write(nums1 + " ");
//					goNext1 = true;
//					goNext2 = false;
//				} else {
//					bw.write(nums2 + " ");
//					goNext2 = true;
//					goNext1 = false;
//				}
//			}
//			
//			if (nums1 > nums2) {
//				bw.write(nums1 + " ");
//			} else {
//				bw.write(nums2 + " ");
//			}
//
//			while (sc1.hasNext() && sc2.hasNext()) {
//				nums1 = Integer.parseInt(sc1.next().trim());
//				bw.write(nums1 + " ");
//			}
//			
//			while (sc2.hasNext()) {
//				nums2 = Integer.parseInt(sc2.next().trim());
//				bw.write(nums2 + " ");
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// Varianta 2 - folosind array-uri rezultate din metoda split

//		try (BufferedReader br1 = new BufferedReader(new FileReader("TemeDevmind/tema18IO/Numbers1.txt"));
//				BufferedReader br2 = new BufferedReader(new FileReader("TemeDevmind/tema18IO/Numbers2.txt"));
//				BufferedWriter bw = new BufferedWriter(new FileWriter("TemeDevmind/tema18IO/NumbersMerge.txt"))) {
//			String line1 = br1.readLine();
//			String line2 = br2.readLine();
//			String[] arr1 = line1.split(" ");
//			String[] arr2 = line2.split(" ");
//			int i = 0;
//			int j = 0;
//			while (i < arr1.length && j < arr2.length) {
//				if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[j])) {
//					bw.write(arr1[i] + " ");
//					i++;
//				} else {
//					bw.write(arr2[j] + " ");
//					j++;
//				}
//			}
//			while (i < arr1.length) {
//				bw.write(arr1[i] + " ");
//				i++;
//			}
//			while (j < arr2.length) {
//				bw.write(arr2[j] + " ");
//				j++;
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}
}
