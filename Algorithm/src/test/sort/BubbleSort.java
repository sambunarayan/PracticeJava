package test.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void print(int[] arr) {
		System.out.print("[");
		System.out.print(Arrays.stream(arr).mapToObj(i->String.valueOf(i)).collect(Collectors.joining(",")));
		System.out.println("]");
	}
	
	public static void main(String... args) {
		int[] arr = {6, 3, 2, 7, 1, 4, 2};
		BubbleSort.print(arr);
		BubbleSort.sort(arr);
		BubbleSort.print(arr);
	}
}
