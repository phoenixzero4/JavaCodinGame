package codinGame;

import java.io.File;
import java.util.Scanner;

/**
 *  phoenix May 8, 2022
 *  
 *  Defibrillators https://www.codingame.com/ide/puzzle/defibrillators 
 *  Classic Puzzle: Easy
 */

public class Defibrillators {

	public static void main(String[] args) throws Exception{
		
//		  Use this for CodinGame		
//		  Scanner in = new Scanner(System.in);
//		  String lon = in.next();
//		  String lat = in.next();
//		  int n = in.nextInt();		 
		
		String filename = "defibInput.txt";
		Scanner in = new Scanner( new File(filename));
		
		String ans = "";
		String lon = in.next();
		double closest = -1;
		
		lon = lon.replace(',', '.');
		double longitude = Double.parseDouble(lon);
		System.err.println("longitude: " + longitude);
		String lat = in.next();
		
		lat = lat.replace(',', '.');
		Double latitude = Double.parseDouble(lat);
		System.out.println("latitude: " + latitude);
		latitude = latitude * Math.PI / 180;
		longitude = longitude * Math.PI / 180;
		int n = Integer.parseInt(in.next());
		System.out.println("n: " + n);
		
		if(in.hasNextLine()) {
			in.nextLine();
		}
		int index = 0;
		for(int i = 0; i < n; i++) {
			String defib = in.nextLine();
			System.out.println("defib: " + defib);
		
				index = defib.lastIndexOf(";");
				String lat2 = defib.substring(index+1);
				lat2 = lat2.replace(',', '.');
				defib = defib.substring(0,index);
				index = defib.lastIndexOf(";");
				String lon2 = defib.substring(index+1);
				lon2 = lon2.replace(',', '.');
				Double dlat2 = Double.parseDouble(lat2);
				Double dlon2 = Double.parseDouble(lon2);
				dlat2 = Math.PI * dlat2 / 180;
				dlon2 = Math.PI * dlon2 / 180;
		
				
				double x = (dlon2 - longitude) * Math.acos( (latitude + dlat2) / 2);
				double y = (dlat2 - latitude);
				double d = Math.sqrt((x * x) + (y * y)) * 6371;
				
				if( d < closest || closest == -1) {
					closest = d;
					String[] array = defib.split(";");
					ans = array[1];
				}
			
		}
		
		System.out.println(ans);
	}

}
