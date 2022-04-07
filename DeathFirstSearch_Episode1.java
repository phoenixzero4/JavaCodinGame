package codinGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class DeathFirstSearch_Episode1 {

	static ArrayList<Integer> nodelist = new ArrayList<>();
	static ArrayList<Integer> exitlist = new ArrayList<>();
	static List<List<Integer>> linkarray = new ArrayList<>();
	static List<Integer> searchOrder = new ArrayList<>();
	static ArrayList<List<Integer>> severed = new ArrayList<>();

	public static List<Integer> bfs(int bob, List<Integer> nodelist, List<List<Integer>> edges, int target) {
		List<Integer> order = new ArrayList<>();
		int[] parent = new int[nodelist.size()];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[nodelist.size()];
		queue.offer(bob);
		isVisited[bob] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			order.add(u);
			for (Integer e : edges.get(u)) {
				if (e == target) {

					return order;
				}
				if (!isVisited[e]) {
					queue.offer(e);
					parent[e] = u;
					isVisited[e] = true;
				}
			}
		}
		return order;
	}

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner in = new Scanner(System.in);
		// int nodes = in.nextInt();
		// int links = in.nextInt();
		// int exits = in.nextInt();
		System.out.println("Enter the name of the input file: ");
		Scanner input = new Scanner(System.in);
		String filename = input.nextLine();
		input.close();
		File file = new File(filename);
		Scanner in = new Scanner(file);
		String[] line = in.nextLine().split(" ");
		for (String s : line) {
			System.err.println(s);
		}
		int nodes = Integer.parseInt(line[0]);
		int links = Integer.parseInt(line[1]);
		int exits = Integer.parseInt(line[2]);

		for (int i = 0; i < nodes; i++) {
			nodelist.add(i);
			List<Integer> list = new ArrayList<>();
			linkarray.add(list);
		}

		for (int i = 0; i < links; i++) {
			// int n1 = in.nextInt();
			// int n2 = in.nextInt();
			line = in.nextLine().split(" ");
			int n1 = Integer.parseInt(line[0]);
			int n2 = Integer.parseInt(line[1]);

			List<Integer> l = linkarray.get(n1);
			l.add(n2);

			l = linkarray.get(n2);
			l.add(n1);

		}
		/*
		 * for (int i = 0; i < linkarray.size(); i++) { for (int j : linkarray.get(i)) {
		 * System.err.print("linkarray.get(" + i + ").get(j): " + j); }
		 * System.err.println(); }
		 */

		for (int i = 0; i < exits; i++) {
			// int ei = in.nextInt();
			line = in.nextLine().split(" ");
			int ei = Integer.parseInt(line[0]);
			exitlist.add(ei);
		}

		boolean first = true;
		int limit = 2;
		while (limit > 0) {
			line = in.nextLine().split(" ");
			int bob = Integer.parseInt(line[0]);
//			int bob = in.nextInt();
			List<Integer> ans = getxy(bob);
			if (first || ans.size() > 2) {
				ans = xy(bob);
			}

			int x = ans.get(0);
			int y = ans.get(1);

			System.err.println("x: " + x + "y: " + y);

			List<Integer> inner = linkarray.get(x);
			if (inner.contains(y)) {
				inner.remove(inner.indexOf(y));
				linkarray.set(x, inner);
			}

			inner = linkarray.get(y);
			if (inner.contains(x)) {
				inner.remove(inner.indexOf(x));
				linkarray.set(y, inner);
			}

			first = false;

			System.out.println(x + " " + y);
			limit--;
		}
	}

	static List<Integer> getxy(int bob) {

		int x = 0;
		int y = 0;
		int closest = Integer.MAX_VALUE;
		for (int j = 0; j < exitlist.size(); j++) {
			int target = exitlist.get(j);
			searchOrder = bfs(bob, nodelist, linkarray, target);
			if (searchOrder.size() < closest) {
				closest = searchOrder.size();
				if (searchOrder.size() > 1) {
					y = searchOrder.get(searchOrder.size() - 1);
					x = target;
				} else {
					x = target;
					y = bob;
				}
			}
		}
		if (closest > 3) {
			return searchOrder;
		}
		List<Integer> ans = new ArrayList<>();
		ans.add(x);
		ans.add(y);
		return ans;

	}

	static List<Integer> xy(int bob) {
		List<Integer> ans = new ArrayList<>();
		int x = 0;
		List<Integer> checklist = linkarray.get(bob);
		x = checklist.get(0);
		for (int e : exitlist) {
			System.err.println("e: " + e);
			if (checklist.contains(e)) {
				x = e;
				ans.add(x);
				ans.add(bob);
				return ans;
			}
		}
		int y = bob;
		int least = 2;
		for (int e : exitlist) {
			List<Integer> templist = linkarray.get(e);
			for (Integer f : templist) {
				List<Integer> list2 = linkarray.get(f);
				if (list2.size() <= least) {
					least = list2.size();
					x = f;
					y = list2.get(0);

				}
			}

		}

		ans.add(x);
		ans.add(y);
		return ans;

	}
}
