package test.search;

import java.util.Scanner;

public class ChainHashTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of input : ");
		int num = scan.nextInt();
		int i = 0;
		ChainHash<Integer, Integer> hash = new ChainHash<>(13);
		while (i < num) {
			System.out.print("Input Key and Value (key,value) : ");
			String in = scan.next();
			String[] arr = in.split(",");
			System.out.println(hash.add(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
			i++;
		}
		
		while (true) {
			System.out.print("search:");
			System.out.println(hash.search(scan.nextInt()));
			
			System.out.print("end(true,false)? ");
			if (scan.next().equals("true")) {
				System.out.println("end. bye.");
				break;
			}
		}
	}
}
