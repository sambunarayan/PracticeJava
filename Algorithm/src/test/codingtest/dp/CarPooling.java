package test.codingtest.dp;

public class CarPooling {
	
	// *****
	// leetCode 1094.CarPooling
	// Using DynamicPromgramming

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean carPooling(int[][] trips, int capacity) {
		int[] passengers = new int[1001];
		for (int[] trip : trips) {
			for (int i = trip[1]; i < trip[2]; i++) {
				passengers[i] += trip[0];
				if (passengers[i] > capacity) {
					return false;
				}
			}
		}
		return true;
	}

}
