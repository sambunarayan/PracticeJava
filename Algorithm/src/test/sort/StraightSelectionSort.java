package test.sort;

import java.util.Arrays;

public class StraightSelectionSort {
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[k] < arr[minIdx]) {
					minIdx = k;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 3, 1, 6};
		StraightSelectionSort.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
