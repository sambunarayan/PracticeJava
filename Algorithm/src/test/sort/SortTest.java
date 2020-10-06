package test.sort;

import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
		int[] arr = new int[80000];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(80000);
		}
		int[] cpyArr = new int[arr.length];
		
		ProcessHandle currentProcess = ProcessHandle.current();
		System.out.println("Current Process Id:" + currentProcess.pid());
		
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
		
		System.arraycopy(arr, 0, cpyArr, 0, arr.length);
		start = System.currentTimeMillis();
		StraightSelectionSort.sort(cpyArr);
		end = System.currentTimeMillis();
		System.out.println("StraightSelectionSort -> " + (end - start));
		
		System.arraycopy(arr, 0, cpyArr, 0, arr.length);
		start = System.currentTimeMillis();
		StraightInsertionSort.sort(cpyArr);
		end = System.currentTimeMillis();
		System.out.println("StraightInsertionSort -> " + (end - start));
		
		System.arraycopy(arr, 0, cpyArr, 0, arr.length);
		start = System.currentTimeMillis();
		ShellSort.sort(cpyArr);
		end = System.currentTimeMillis();
		System.out.println("ShellSort -> " + (end - start));
		
		System.arraycopy(arr, 0, cpyArr, 0, arr.length);
		start = System.currentTimeMillis();
		MergeSort.sort(cpyArr);
		end = System.currentTimeMillis();
		System.out.println("MergeSort -> " + (end - start));
	}

}
