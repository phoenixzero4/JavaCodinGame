package codinGame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Anagrams {

	static List<Integer> second;
	static List<Integer> third;
	static List<Integer> four;
	static StringBuilder ans;

	public static void main(String[] args) throws IOException {
		String s = "input.txt";
		File file = new File(s);
		Scanner in = new Scanner(file);
		String phrase = in.nextLine();
		ans = new StringBuilder();
		String[] array = phrase.split(" ");

		int[] nums = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			nums[i] = array[i].length();
		}
		int prev = 0;
		int end = 0;
		phrase = phrase.replaceAll(" ", "");
		for (int i = nums.length - 1; i >= 0; i--) {
			end += nums[i];
			ans.append(phrase.substring(prev, end) + " ");
			prev = end;
		}
		List<Integer> second = new ArrayList<>();
		List<Integer> third = new ArrayList<>();
		List<Integer> four = new ArrayList<>();

		for (int i = 66; i < 91; i += 2) {
			second.add(i);
			System.err.print((char) i + " ");
		}
		System.err.println();
		for (int i = 67; i < 91; i += 3) {
			third.add(i);
			System.err.print((char) i + " ");
		}
		System.err.println();
		for (int i = 68; i < 91; i += 4) {
			four.add(i);
			System.err.print((char) i + " ");
		}
		System.err.println();

		shiftRight(four, true);
		shiftLeft(third);
		shiftRight(second, false);
		System.out.println(ans.toString().trim());
	}

	public static void shiftLeft(List<Integer> list) {
		TreeMap<Integer, Character> map = new TreeMap<>();
		String result = "";
		for (int i = 0; i < ans.length(); i++) {
			if (list.contains((int) ans.charAt(i))) {
				map.put(i, ans.charAt(i));
				result += ans.charAt(i);
			}
		}
		if (result.length() > 0) {
			char[] r = result.toCharArray();
			char c = r[0];
			for (int i = r.length - 1; i >= 0; i--) {
				char temp = r[i];
				r[i] = c;
				c = temp;
			}
			result = String.valueOf(r);
			Set<Integer> keys = map.keySet();
			int j = 0;
			for (Integer i : keys) {
				ans.setCharAt(i, r[j]);
				j++;
			}
		}
	}

	public static void shiftRight(List<Integer> list, boolean x) {
		TreeMap<Integer, Character> map = new TreeMap<>();
		String result = "";
		for (int i = 0; i < ans.length(); i++) {
			if (list.contains((int) ans.charAt(i))) {
				map.put(i, ans.charAt(i));
				result += ans.charAt(i);
			}
		}
		if (result.length() > 0) {
			System.err.println(result);
			char[] r;
			if (x) {
				r = result.toCharArray();
				char f = r[r.length - 1];
				for (int i = 0; i < r.length; i++) {
					char temp = r[i];
					r[i] = f;
					f = temp;
				}

			} else {
				r = new char[result.length()];
				for (int i = 0, j = result.length() - 1; i < r.length; i++, j--) {
					r[i] = result.charAt(j);
				}
			}
			result = String.valueOf(r);
			Set<Integer> keys = map.keySet();
			int j = 0;
			for (Integer i : keys) {
				ans.setCharAt(i, r[j]);
				j++;
			}
		}
	}

}
