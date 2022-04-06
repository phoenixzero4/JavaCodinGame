
package codingame;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Phoenix
 *
 */
public class OffsetArrays {

	public static void main(String[] args) throws IOException {

		HashMap<String, int[]> map = new HashMap<>();
		File file = new File("custom1.txt");
		Scanner in = new Scanner(file);

		int n = in.nextInt();
		in.nextLine();
		// int index = 0;
		String[] registry = new String[n];
		for (int i = 0; i < n; i++) {
			registry[i] = in.nextLine();
		}
		String lastline = in.nextLine();

		LinkedList<String> l = new LinkedList<>();

		StringBuilder a = new StringBuilder(lastline);
		int outerp = lastline.indexOf("[");
		String aname = new String(lastline.substring(0, outerp));

		while (a.indexOf("[") != -1) {
			outerp = a.indexOf("[");
			aname = a.substring(0, outerp);
			l.add(aname);
			a.delete(0, outerp + 1);
			a.delete(a.length() - 1, a.length());
		}

		int linelen = lastline.length();
		int stopindex = 0;
		for (int i = linelen - 1; i >= 0; i--) {
			if (lastline.charAt(i) == '[') {
				stopindex = i;
				break;
			}
		}

		int ns = Integer.parseInt(lastline.substring(stopindex + 1, lastline.indexOf("]")));
		for (String line : registry) {

			int outerLeftP = line.indexOf("[");
			String arrayName = line.substring(0, outerLeftP);

			int firstPeriod = line.indexOf(".");
			int begin = Integer.parseInt(line.substring(outerLeftP + 1, firstPeriod));

			int equalSign = line.indexOf("=");
			String elemString = line.substring(equalSign + 2);
			String[] arrayString = elemString.split(" ");
			int[] elems = new int[arrayString.length + 1];
			for (int j = 0; j < arrayString.length; j++) {
				elems[j] = Integer.parseInt(arrayString[j]);
			}
			elems[arrayString.length] = begin;
			map.put(arrayName, elems);

		}
		while (l.size() > 0) {
			aname = l.getLast();
			int[] cur = map.get(aname);
			int beginIndex = cur[cur.length - 1];
			ns = cur[ns - beginIndex];
			l.removeLast();

		}
		System.out.println(ns);
	}
}
