/**
 * 
 */
package codinGame;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Phoenix
 *
 */
public class TheGift {

	public static void main(String[] args) throws IOException {

		String file = "input.txt";
		File f = new File(file);
		Scanner in = new Scanner(f);

		int n = Integer.parseInt(in.nextLine());
		int c = Integer.parseInt(in.nextLine());

		// For coding game
		/*
		 * Scanner in = new Scanner(System.in);
		 * int n = in.nextInt();
		 * int c = in.nextInt();
		 */

		int[] array = new int[n];
		int[] cont = new int[n];

		/*
		 * for (int i = 0; i < n; i++) {
		 * int b = in.nextInt();
		 * array[i] = b;
		 * }
		 */
		int total = 0;
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(in.nextLine());
			total += array[i];
		}

		if (total < c) {
			System.out.println("IMPOSSIBLE");
		} else {
			Arrays.sort(array);
			int cost = c;
			int prev = 0;
			for (int i = 0; i < array.length; i++) {

				if (cost > array[i] * (n - i)) {
					cost -= array[i];
					cont[i] = array[i];

				} else {
					double a = cost / (n - i);
					System.err.println(a);
					cont[i] = (int) a;
					cost -= cont[i];
				}
			}
			for (int i = 0; i < cont.length; i++) {
				System.out.println("Person " + i + " contributes " + cont[i]);
			}
		}

	}
}
