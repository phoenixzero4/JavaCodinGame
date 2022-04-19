package codinGame;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author phoenix
 * 
 *This solution (I misunderstood the problem definition) counts all the 
 *occurrences of integers and sums them (rather than summing only consecutive 
 *appearances). So, while it works for what I wrote it for - I wrote it for 
 *the wrong problem. 
 * 
 *
 */
public class ConwaySequence {
	public static HashMap<Integer, Integer> map = new HashMap<>();
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static HashMap<Integer, Integer> conway(int number, int line) {
		String[] str;
		map.put(number, 1);
		while(line > 0) {
			
			System.err.println("Iteration " + line);
		String ans = "";
		str = new String[ans.length()];
		for(Integer key: map.keySet()) {
			int val = map.get(key);
			System.err.println("map.key: " + key + " map.val: " + val);
			
				if(val > 0) {
				ans += String.valueOf(val) +""+ String.valueOf(key);
				}map.put(key, 0);
			}
			
		
		
			System.err.print("ans1: " + ans);
			str = ans.split("");
			ans = new String();
			System.err.print("\nans: " + ans);
			for(int i = 0; i < str.length; i++) {
				int elem = Integer.parseInt(str[i]);
				map.put(elem,  map.get(elem) + 1);
				}
			System.err.println();
			System.err.println("End iteration: " + line +"\n\n");
			line--;
			
		}
		return map;
	}
	
	public static void main(String...strings) {
		int number = 1;
		int line = 6;
		 for(int i = 0; i < 10; i++) {
			 map.put(i, 0);
		 }
		conway(number, line);
		for(int i = 0; i < 10; i++) {
			int val = map.get(i);
			if(val > 0) {
				System.out.print(i + " " + val + " ");
			}
		}
		
	}
}
