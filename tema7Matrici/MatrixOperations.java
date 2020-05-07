package tema7Matrici;

public class MatrixOperations {

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] sumMatrix(int matrix1[][], int matrix2[][], int rowSize, int colSize) {
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				result[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return result;
	}

	public int[][] subtractMatrix(int[][] matrix1, int[][] matrix2, int rowSize, int colSize) {
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				result[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		return result;
	}

	public int[][] multiplicationWithScalar(int[][] matrix, int rowSize, int colSize, int number) {
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				result[i][j] = number * matrix[i][j];
			}
		}
		return result;
	}

	public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2, int rowSize1, int colSize1, int colSize2) {
		int[][] result = new int[rowSize1][colSize2];
		for (int i = 0; i < rowSize1; i++) {
			for (int j = 0; j < colSize2; j++) {
				for (int k = 0; k < colSize1; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		return result;
	}

}
