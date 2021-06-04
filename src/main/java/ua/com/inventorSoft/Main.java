package ua.com.inventorSoft;

public class Main {
	public static void main(String[] args) {

		System.out.println(arrayChallenge(new int[]{1, 5,10,10}));

	}

	public static int arrayChallenge(int[] arr) {
		int length = arr.length;

		if (length == 1 || arr[length - 1] == 1) {
			return -1;
		}
		int row = arr[1] + 1;
		int lastNumber = arr.length - 1;

		int[][] triangle = new int[row][row];

		for (int line = 0; line < row; line++) {
			for (int i = 0; i <= line; i++) {
				if (line == i || i == 0) {
					triangle[line][i] = 1;
				} else {
					triangle[line][i] = triangle[line - 1][i - 1] + triangle[line - 1][i];
				}
				if (line == row - 1 && i == lastNumber + 1) {
					return triangle[row - 1][lastNumber + 1];
				}
			}
		}
		return -1;
	}
}
