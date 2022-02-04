package codingame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentenceTokenising {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		int n = in.nextInt();
		if (in.hasNextLine()) {
			in.nextLine();
		}
		List<String> a = new ArrayList<>();
		String ans = "";
		String special = "";
		boolean prev = false;
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (Character.isAlphabetic(c)) {
				if (special.length() > 0) {
					a.add(special);
					special = "";
				}
				ans += c;
			} else {
				if (ans.length() > 0) {
					a.add(ans);
					ans = "";
				}
				if (c != ' ') {
					special += c;
				} else {
					if (special.length() > 0) {
						a.add(special);
						special = "";
					}
				}

			}

			if (ans.length() > 0 && i == sentence.length() - 1) {
				a.add(ans);
			}
			if (special.length() > 0 && i == sentence.length() - 1) {
				a.add(special);
			}
		}

		for (int i = 0; i < n; i++) {
			String operation = in.nextLine();
			String[] ops = operation.split(" ");
			if (ops.length == 1) {
				break;
			}

			String op = ops[0];
			int index = Integer.parseInt(ops[1]);
			String token = ops[2];
			if (op.equals("INSERT")) {

				List<String> newlist = new ArrayList<>();
				int l = 0;
				for (int j = 0; j <= a.size(); j++) {

					if (j == index) {
						newlist.add(token);
					} else {
						newlist.add(a.get(l));
						l++;
					}
				}
				a = newlist;

			} else if (op.equals("REMOVE")) {
				int toke = Integer.parseInt(token);
				String[] gottago = new String[toke];
				for (int j = 0; j < toke; j++) {
					gottago[j] = a.get(index + j);
				}
				for (String s : gottago) {
					a.remove(s);
				}
			} else if (op.equals("SWITCH")) {
				String temp = a.get(index);
				int index2 = Integer.parseInt(token);
				String temp2 = a.get(index2);
				int elem = a.indexOf(temp2);
				a.set(a.indexOf(temp), temp2);
				a.set(elem, temp);
			}
		}
		for (String s : a) {
			System.out.println(s);
		}
	}
}
