package tema18IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1 {

	public static void replaceWords(String word1, String word2) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("TemeDevmind/tema18IO/TextInput.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("TemeDevmind/tema18IO/TextOutput.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line.replaceAll(word1, word2) + "\n");
			}
		}
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Introduceti primul cuvant:");
			String word1 = br.readLine();
			System.out.println("Introduceti al doilea cuvant:");
			String word2 = br.readLine();
			replaceWords(word1, word2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
