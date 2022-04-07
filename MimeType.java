/**
 * 
 */
package codinGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Phoenix
 *
 */
public class MimeType {

	public static void main(String[] args) throws FileNotFoundException {

		String str = "mime.txt";
		File file = new File(str);
		Scanner in = new Scanner(file);

		HashMap<String, String> map = new HashMap<>();

		int n = Integer.valueOf(in.nextLine());
		int q = Integer.parseInt(in.nextLine());
		for (int i = 0; i < n; i++) {
			String e = in.next();
			String m = in.next();
			map.put(e, m);
		}
		in.nextLine();
		for (int i = 0; i < q; i++) {
			String f = in.nextLine();
			int index = f.lastIndexOf(".");
			String ext = f.substring(index + 1).toLowerCase();
			// ext.toUpperCase();
			// System.out.println(f + " " + ext);
			if (map.containsKey(ext)) {
				System.out.println(map.get(ext));
			} else if (map.containsKey(ext.toUpperCase())) {
				System.out.println(map.get(ext.toUpperCase()));
			} else {
				System.out.println("UNKNOWN");
			}
		}
	}
}
