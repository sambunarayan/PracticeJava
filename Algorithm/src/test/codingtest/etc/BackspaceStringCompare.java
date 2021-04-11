package test.codingtest.etc;

import java.util.Stack;

public class BackspaceStringCompare {

	// **
	// leetcode 844. Backspace String compare
	// Using Stack.
	//

	public static void main(String[] args) {

	}

	public boolean backspaceCompare(String S, String T) {
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		char[] arr1 = S.toCharArray();
		char[] arr2 = T.toCharArray();
		int i1 = 0;
		int i2 = 0;
		while (i1 < arr1.length) {
			if (arr1[i1] == '#') {
				if (!stack1.isEmpty())
					stack1.pop();
			} else {
				stack1.push(arr1[i1]);
			}
			i1++;
		}
		while (i2 < arr2.length) {
			if (arr2[i2] == '#') {
				if (!stack2.isEmpty())
					stack2.pop();
			} else {
				stack2.push(arr2[i2]);
			}
			i2++;
		}
		// System.out.println("stack1:" + stack1 + ", stack2:" + stack2);
		if (stack1.size() != stack2.size()) {
			return false;
		}
		while (!stack1.isEmpty()) {
			if (stack1.pop() != stack2.pop()) {
				return false;
			}
		}
		return true;
	}
}
