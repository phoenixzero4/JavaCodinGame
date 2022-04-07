/**
 * 
 */
package codinGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Phoenix
 *
 */
public class HorseRacingDuals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int i, d;
		int diff = 99;

		int n = in.nextInt();
		ArrayList<Integer> horses = new ArrayList<Integer>();

		for (i = 0; i < n; i++) {
			horses.add(in.nextInt());
		}

		horses.sort(null);
		for (i = 1; i < n; i++) {
			d = horses.get(i) - horses.get(i - 1);
			if (d < diff) {
				diff = d;
			}
		}

		System.out.println(diff);

	}
}
