package ua.com.inventorSoft;

public class Main {
	public static void main(String[] args) {

		System.out.println(arrayChallenge(new int[]{1, 5, 10, 10}));

	}

	public static int arrayChallenge(int[] arr) {
		int length = arr.length;

		if (length == 1 || arr[length - 1] == 1) {
			return -1;
		}
		//define how many rows of pascal triangle to build.
		// For instance if second number entered row is 5 then we should build 6 rows
		int row = arr[1] + 1;
		// define index of last number entered row.
		int lastNumber = arr.length - 1;

		int[][] triangle = new int[row][row];

		//building pascal's triangle
		for (int column = 0; column < row; column++) {
			for (int i = 0; i <= column; i++) {
				if (column == i || i == 0) {
					triangle[column][i] = 1;
				} else {
					triangle[column][i] = triangle[column - 1][i - 1] + triangle[column - 1][i];
				}

				//checks if particular row and index is number we need
				if (column == row - 1 && i == lastNumber + 1) {
					return triangle[row - 1][lastNumber + 1];
				}
			}
		}
		return -1;
	}
}
