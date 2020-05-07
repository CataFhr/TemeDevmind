package tema7Matrici;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MatrixWithArrayList {

	public static void main(String[] args) {

		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {

			System.out.println("Introduceti dimensiunea matricei patratice:");
			int matrixDimension = Integer.parseInt(br.readLine());
			System.out.println("Introduceti valoarea elem. de pe diagonala principala:");
			int mainDiagValue = Integer.parseInt(br.readLine());
			System.out.println("Introduceti valoarea elem. de pe diagonala secundara:");
			int sndDiagValue = Integer.parseInt(br.readLine());
			int centerValue = -1;
			if (matrixDimension % 2 != 0) {
				System.out.println("Introduceti valoarea elem. din centrul matricii:");
				centerValue = Integer.parseInt(br.readLine());
			}
			System.out.println("Introduceti valoarea elem. din cadranul stang:");
			int leftValue = Integer.parseInt(br.readLine());
			System.out.println("Introduceti valoarea elem. din cadranul de sus:");
			int upValue = Integer.parseInt(br.readLine());
			System.out.println("Introduceti valoarea elem. din cadranul drept:");
			int rightValue = Integer.parseInt(br.readLine());
			System.out.println("Introduceti valoarea elem. din cadranul de jos:");
			int bottomValue = Integer.parseInt(br.readLine());

			ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>(matrixDimension);
			int n = matrixDimension;
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> newRow = new ArrayList<Integer>(n);
				for (int j = 0; j < n; j++) {
					if (i == j) {
						newRow.add(mainDiagValue);
					} else if (i + j == n - 1) {
						newRow.add(sndDiagValue);
					}
					if (i > j && i + j < n - 1) {
						newRow.add(leftValue);
					} else if (i < j && i + j < n - 1) {
						newRow.add(upValue);
					} else if (i < j && i + j > n - 1) {
						newRow.add(rightValue);
					} else if (i > j && i + j > n - 1) {
						newRow.add(bottomValue);
					}
				}
				matrix.add(newRow);
			}
			if (matrixDimension % 2 != 0) {
				matrix.get(n / 2).set(n / 2, centerValue);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(matrix.get(i).get(j) + " ");
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
