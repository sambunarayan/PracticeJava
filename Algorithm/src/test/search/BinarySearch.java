package test.search;

import java.util.Scanner;

public class BinarySearch {
	
	private int[] array;
	
	public BinarySearch(int[] array) {
		this.array = array;
	}
	
	public int search(int n) {
		int pl = 0;
		int pr = array.length - 1;
		do {
			int pc = (pl + pr) / 2;
			if (array[pc] == n) {
				return pc;
			} else if (array[pc] < n) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		} while (pl <= pr);
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of input : ");
		int num = scan.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print((i + 1) + "->");
			arr[i] = scan.nextInt();
		}
		BinarySearch binarySearch = new BinarySearch(arr);
		System.out.print("Search element :");
		int n = scan.nextInt();
		System.out.println(binarySearch.search(n) + 1);
	}

}
