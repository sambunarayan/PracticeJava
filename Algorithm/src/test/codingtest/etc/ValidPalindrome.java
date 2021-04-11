package test.codingtest.etc;

public class ValidPalindrome {

	// ***
	// leetCode 125. Valid Palindrome
	// Using Pointer

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(String s) {

		char[] arr = s.toCharArray();
		char[] toLowerArr = new char[arr.length];
		int lIdx = 0;
		int rIdx = -1;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= '0' && arr[i] <= '9')) {
				toLowerArr[++rIdx] = arr[i];
			} else if (arr[i] >= 'A' && arr[i] <= 'Z') {
				toLowerArr[++rIdx] = (char) (arr[i] + 32);
			}
		}
		while (lIdx < rIdx) {
			if (toLowerArr[lIdx++] != toLowerArr[rIdx--])
				return false;
		}
		return true;
	}
}
