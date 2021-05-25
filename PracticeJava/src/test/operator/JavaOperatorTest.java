package test.operator;

public class JavaOperatorTest {

	public static void main(String[] args) {
		// Shift Operator
		// left shift
		System.out.println("2 << 3 = " + (2 << 3));
		// right shift
		System.out.println("16 >> 3 = " + (16 >> 3));
		System.out.println("-16 >> 3 = " + (-16 >> 3));
		System.out.println("-16 >>> 3 = " + (-16 >>> 3));

		// Bit Operator
		int n1 = 0b00001010;
		int n2 = 0b00001101;

		System.out.println("AND Operator -> " + (n1 & n2) + toBinaryStr((n1 & n2)));
		System.out.println("OR Operator -> " + (n1 | n2) + toBinaryStr((n1 | n2)));
		System.out.println("XOR Operator -> " + (n1 ^ n2) + toBinaryStr((n1 ^ n2)));

		// ReverseBit
		int n3 = 0b11111111111111111111111111110101;
		System.out.println("Reverse Bit Operator -> " + (~n1) + toBinaryStr((~n1)));
		System.out.println("Reverse Bit Operator -> " + (~n3) + toBinaryStr((~n3)));
	}

	private static String toBinaryStr(int b) {
		return " -> " + String.format("%8s", Integer.toBinaryString(b).replace(' ', '0'));
	}
}
