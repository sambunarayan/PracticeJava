package test.sort;

public class StraightInsertionSort {
	
	public static void sort(int[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int k = i - 1;
			while (k >= 0) {
				if (arr[k] > target) {
					arr[k + 1] = arr[k];
				} else {
					break;
				}
				k--;
			}
			arr[k + 1] = target;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6, 4, 1, 7, 3, 9, 8};
		StraightInsertionSort.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
