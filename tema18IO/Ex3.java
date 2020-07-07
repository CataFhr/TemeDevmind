package tema18IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new FileWriter("TemeDevmind/tema18IO/result.txt"))) {

			System.out.println("Introduceti numarul de cuvinte din lista");
			int n = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			String longestWord = null;
			String shortestWord = null;
			int maxLength = 0;
			int minLength = Integer.MAX_VALUE;
			System.out.println("Introduceti cuvintele");
			for (int i = 0; i < n; i++) {
				String word = br.readLine();
				list.add(word);
				if (word.length() > maxLength) {
					maxLength = word.length();
					longestWord = word;
				}
				if (word.length() < minLength) {
					minLength = word.length();
					shortestWord = word;
				}
			}
			System.out.println("Lista este: " + list);
			bw.write("Cel mai lung cuvant este: " + longestWord + "\n");
			bw.write("Cel mai scurt cuvant este: " + shortestWord + "\n");
			Collections.sort(list);
			bw.write("Primul cuvant in ordine alfabetica: " + list.get(0) + "\n");
			bw.write("Ultimul cuvant in ordine alfabetica: " + list.get(list.size() - 1) + "\n");
			bw.write("Numarul total de cuvinte este: " + list.size());

		} catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

}
