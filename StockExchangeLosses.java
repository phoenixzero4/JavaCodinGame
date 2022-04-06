package codinGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StockExchangeLosses {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("file1.txt");
		Scanner in = new Scanner(file);
		
		int stocks = Integer.parseInt(in.nextLine());
		int[] values = new int[stocks];
		
		int highestSoFar = -1, lowestSoFar = Integer.MAX_VALUE, diff = 0;
		int hindex = -1, lindex = -1;
		int current;
		for(int i = 0; i < stocks; i++) {
			current = Integer.parseInt(in.next());
			values[i] = current;
			
			if(current > highestSoFar) {
				highestSoFar = current;
				hindex = i;
			}
			if(current < highestSoFar && i != hindex) {
				lowestSoFar = current;
				lindex = i;
			}
			if(lindex > hindex && highestSoFar - lowestSoFar > diff) {
				diff = highestSoFar - lowestSoFar;
			}
			
		}
		System.out.println(diff*-1);
	}
}
