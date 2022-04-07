/**
 * 
 */
package codinGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Phoenix
 *
 */
public class LongestSequenceOfOnes {

	public static void main(String[] args) throws FileNotFoundException {

		String bitstring;
		Scanner in;
		List<Integer> list = new ArrayList<>();
		int index = 0;
		String winnerString = "";

		if (args.length > 0) {
			String filename = args[0];
			File file = new File(filename);
			in = new Scanner(file);
			bitstring = in.nextLine();
		} else {
			bitstring = "11011101111";
			StringBuilder s = new StringBuilder(bitstring);
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					list.add(i);
					System.out.println("Adding " + i);
				}
			}
			int longest = 0;

			for (Integer i : list) {

				System.out.println("s: " + s.toString());
				System.out.println("Setting char at: " + i + " to 1");
				System.out.println("previously " + s.charAt(i));
				int sum = 0;
				s.setCharAt(i, '1');

				System.out.println("Now s is : " + s.toString());
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == '1') {
						sum++;
					} else {
						if (sum > longest) {
							longest = sum;
							winnerString = s.toString();
							index = i;

						}
						sum = 0;
					}
					if (sum > longest) {
						longest = sum;
						winnerString = s.toString();
						index = i;

					}

				}
				s.setCharAt(i, '0');
			}

			System.out.println("\nLongest sequence of ones is " + longest);
			System.out.println("Found in bitstring " + winnerString + " after flipping index: " + index);
		}

	}

}
