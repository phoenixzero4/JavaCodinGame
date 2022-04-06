package codingame;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

class ThereIsNoSpoon {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int width = in.nextInt(); // the number of cells on the X axis
		int height = in.nextInt(); // the number of cells on the Y axis
		if (in.hasNextLine()) {
			in.nextLine();
		}

		char[][] grid = new char[height][width];
		for (int i = 0; i < height; i++) {
			String line = in.nextLine();
			line.getChars(0, line.length(), grid[i], 0);
		}

		LinkedList<int[]> ans = new LinkedList<>();

		for (int xcord = 0; xcord < height; xcord++) {
			for (int ycord = 0; ycord < width; ycord++) {
				char c = grid[xcord][ycord];

				if (c == '0') {
					// array to hold the 6 output values for each found
					int[] a = new int[6];
					Arrays.fill(a, -1);

					a[0] = ycord;
					a[1] = xcord;
					ans.add(a);
				}
			}

		}
		int y;

		for (y = 0; y < ans.size() - 1; y++) {
			int[] arr = ans.get(y);

			for (int x = 0; x < ans.size(); x++) {
				int[] arr2 = ans.get(x);

				if (arr[1] < arr2[1] && arr[0] == arr2[0] && arr[5] == -1) {
					arr[4] = arr2[0];
					arr[5] = arr2[1];
				}
				if (arr[0] < arr2[0] && arr[1] == arr2[1] && arr[3] == -1) {
					arr[2] = arr2[0];
					arr[3] = arr2[1];
				}
			}
		}
		for (int[] array : ans) {
			for (int k = 0; k < array.length; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.println();

		}
		in.close();
	}
}