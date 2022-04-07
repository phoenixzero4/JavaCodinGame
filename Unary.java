/**
 * 
 */
package codinGame;

import java.util.Scanner;

/**
 * @author Phoenix
 *
 */
public class Unary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// String m = in.nextLine();
		String ans = "";
		String m = "C";

		for (int i = 0; i < m.length(); i++) {
			byte[] array = m.substring(i, i + 1).getBytes();
			int x = array[i];
			System.out.println(x);
			String s = Integer.toBinaryString(x);
			System.out.println(s);

			ans = "";
			String one = "0";

			int index = 0;
			while (s.length() > 0) {

				if (s.charAt(0) == '1') {
					index = s.indexOf('0');
					one = "0 ";

				}
				if (s.charAt(0) == '0') {
					index = s.indexOf('1');
					one = "00 ";
				}
				ans += one;

				for (int j = 0; j < (index); j++) {
					if (j + 1 == index) {
						ans += "0 ";
					} else {
						ans += "0";
					}
				}

				if (index != -1) {
					s = s.substring(index);
				} else {
					// s = s.substring(0, s.length() - 2);
					for (int k = 0; k < s.length(); k++) {
						ans += "0";
					}
					break;
				}

			}
			System.out.println(ans);

		}
	}
}
