package test.codingtest.bottomup;

import java.util.List;

public class Triangle {

	// *****
	// leetCode.120 Triangle 
	// Using Bottom-up algorithm.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumTotal(List<List<Integer>> triangle) {
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int k = 0; k < triangle.get(i).size(); k++) {
				int top = triangle.get(i).get(k);
				int bottom1 = triangle.get(i + 1).get(k);
				int bottom2 = triangle.get(i + 1).get(k + 1);
				triangle.get(i).set(k, top + (Math.min(bottom1, bottom2)));
			}
		}
		return triangle.get(0).get(0);
	}

}
