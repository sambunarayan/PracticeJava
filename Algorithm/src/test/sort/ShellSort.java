package test.sort;

public class ShellSort {
	
	public static void sort(int[] arr) {
		
		int n = arr.length;
		for (int g = n / 2; g > 0; g /= 2) {
			for (int i = g; i < arr.length; i++) {
				int j;
				int temp = arr[i];
				for (j = i - g; j >= 0 && arr[j] > temp; j -= g) {
					arr[j + g] = arr[j];
				}
				arr[j + g] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 2, 3, 7, 1, 8};
		ShellSort.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
