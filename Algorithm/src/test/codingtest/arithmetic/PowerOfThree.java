package test.codingtest.arithmetic;

public class PowerOfThree {

	// ***
	// leetCode.326 Power of Three
	// Using Base Conversion

	public static void main(String[] args) {

	}

	public boolean isPowerOfThree(int n) {
		// System.out.println(Integer.toString(n, 3));
		return Integer.toString(n, 3).matches("^10*$");
	}

}
