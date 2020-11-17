package test.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
	
	private static void swap(int[] arr, int pl, int pr) {
		int temp = arr[pl];
		arr[pl] = arr[pr];
		arr[pr] = temp;
	}
	
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = arr[(left + right) / 2];
		do {
			while (arr[pl] < pivot) pl++;
			while (arr[pr] > pivot) pr--;
			if (pl <= pr) {
				swap(arr, pl++, pr--);
			}
		} while (pl <= pr);
		
		if (left < pr) sort(arr, left, pr);
		if (pl < right) sort(arr, pl, right);
	}
	
	public static void print(int[] arr) {
		System.out.print("[");
		System.out.print(Arrays.stream(arr).mapToObj(i->String.valueOf(i)).collect(Collectors.joining(",")));
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		int[] arr = {6,3,2,7,1,4,2};
		QuickSort.print(arr);
		QuickSort.sort(arr);
		QuickSort.print(arr);
	}
}
