package test.codingtest.recursive;

import java.util.Scanner;

public class BrokenCalculator {
	
	// leetcode 991.Broken Calculator

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int X = scan.nextInt();
		int Y = scan.nextInt();
		
		System.out.println("res -> " + new BrokenCalculator().brokenCalc(X, Y));
	}

	public int brokenCalc(int X, int Y) {
        if (X == Y) return 0;
        if (Y < X) return X - Y;
        
        if (X * 2 == Y) return 1;
        else if (Y % 2 == 0) return brokenCalc(X, Y / 2) + 1;
        else return brokenCalc(X, Y + 1) + 1;
    }
}
