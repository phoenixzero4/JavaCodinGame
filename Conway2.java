package codinGame;

import java.util.ArrayList;

public class Conway2 {

	static ArrayList<Integer> list = new ArrayList<>();	
	public static void conway(int number, int line) {

		String string = "";

		String answer = String.valueOf(number);
		StringBuilder sb = new StringBuilder(answer);
		int count = 0;
		while(line > 1) {
			string = answer;
			sb = new StringBuilder(string);
			answer = "";

			while(string.length() > 0) {
				String x = string.substring(0,1);
				count = 1;
				string = string.substring(1);
				for(int j = 0; j < string.length(); j++) {
					String y = string.substring(0,1);
					if(y.equals(x)) {
						count++;
						string = string.substring(1);
					}
				}
				answer += String.valueOf(count) + x;
		
				
			}
			line--;
			String[] array = answer.split("");
			System.err.println();
	        for(int i = 0; i < array.length; i++){
	            if(i < array.length-1){
	                System.err.print(array[i] + " ");
	            }else{
	                System.err.print(array[i]);
	            }
	        }	
		}
		String[] array = answer.split("");
		System.out.println();
        for(int i = 0; i < array.length; i++){
            if(i < array.length-1){
                System.out.print(array[i] + " ");
            }else{
                System.out.print(array[i]);
            }
        }	
	}		
		
		public static void main(String[] args) {
			int number = 25;
			int line = 10;
			
			conway(number, line);
			
		}
}
