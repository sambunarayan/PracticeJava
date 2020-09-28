package test.sort;

import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
		int[] arr = new int[50000];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(50000);
		}
		int[] cpyArr = new int[arr.length];
		
		System.arraycopy(arr, 0, cpyArr, 0, arr.length);
		long start = System.currentTimeMillis();
		BubbleSort.sort(cpyArr);
		long end = System.currentTimeMillis();
		System.out.println("BubbleSort -> " + (end - start));
		
		System.arraycopy(arr, 0, cpyArr, 0, arr.length);
		start = System.currentTimeMillis();
		QuickSort.sort(cpyArr);
		end = System.currentTimeMillis();
		System.out.println("QuickSort -> " + (end - start));
	}

}
