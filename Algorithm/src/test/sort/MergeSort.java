package test.sort;

public class MergeSort {
	
	private static int[] buff;
	
	private static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int cen = (left + right) / 2;
			int buffPoint = 0;
			int buffSize = 0;
			int rPoint = cen + 1;
			int arrPoint = left;
			sort(arr, left, cen);
			sort(arr, cen + 1, right);
			
			for (int i = left; i <= cen; i++) {
				buff[buffSize++] = arr[i]; 
			}
			while (rPoint <= right && buffPoint < buffSize) {
				arr[arrPoint++] = (buff[buffPoint] <= arr[rPoint]) ? buff[buffPoint++] : arr[rPoint++];
			}
			while (buffPoint < buffSize) {
				arr[arrPoint++] = buff[buffPoint++];
			}
		}
	}
	
	public static void sort(int[] arr) {
		buff = new int[arr.length];
		sort(arr, 0, arr.length - 1);
		buff = null;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 1, 6, 2, 7, 8, 4, 5};
		MergeSort.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
