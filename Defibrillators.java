package codinGame;

import java.io.File;
import java.util.Scanner;

/**
 * phoenix May 8, 2022
 * 
 * Defibrillators -- Classic Puzzle:Easy
 * https://www.codingame.com/ide/puzzle/defibrillators
 * 
 */

public class Defibrillators {

	public static void main(String[] args) throws Exception {

//		  Use this for CodinGame		
//		  Scanner in = new Scanner(System.in);
//		  String lon = in.next();
//		  String lat = in.next();
//		  int n = in.nextInt();		 

		String filename = "defibInput.txt";
		Scanner in = new Scanner(new File(filename));

		String ans = "";
		String defib;
		double closest = -1;

		String lon = in.next();
		lon = lon.replace(',', '.');
		double longitude = Double.parseDouble(lon);

		String lat = in.next();
		lat = lat.replace(',', '.');
		Double latitude = Double.parseDouble(lat);

		// convert latitude and longitude to radians
		latitude = latitude * Math.PI / 180;
		longitude = longitude * Math.PI / 180;

		int n = Integer.parseInt(in.next());

		if (in.hasNextLine()) {
			in.nextLine();
		}

		String lat2, lon2;
		Double dlat2, dlon2;

		for (int i = 0; i < n; i++) {
			defib = in.nextLine();

			String[] array = defib.split(";");

			// String is given as "index;name;address;longitude;latitude"
			// ex. 75;Universite Montpellier 1 UFR Staps
			// (P1);;;3,84875782514269;43,6393278958929
			// (with inconsistent numbers of colons between values) ???

			int length = array.length;
			lat2 = array[length - 1];
			lon2 = array[length - 2];
			String name = array[1];
			lon2 = lon2.replace(',', '.');
			lat2 = lat2.replace(',', '.');

			// convert lat2 and lon2 to radians
			dlat2 = Math.toRadians(Double.parseDouble(lat2));
			dlon2 = Math.toRadians(Double.parseDouble(lon2));

			// formula for distance (using radians)

			// x = (logitudeB - longitudeA) * cos((latitudeA + latitudeB) / 2)
			double x = (dlon2 - longitude) * Math.acos((latitude + dlat2) / 2);

			// y = latitudeB - latitudeA
			double y = (dlat2 - latitude);

			// distance = Math.sqrt((x^2) + (y^2)) * 6371 (radius of Earth in km
			double d = Math.sqrt((x * x) + (y * y)) * 6371;

			if (d < closest || closest == -1) {
				closest = d;
				ans = name;
			}

		}
		System.out.println(ans);
	}

}
