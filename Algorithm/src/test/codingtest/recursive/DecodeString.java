package test.codingtest.recursive;

public class DecodeString {
	
	// *****
	// leetCode.394 Decode String
	// Using recursive solution.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String decodeString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (isNumber(arr[i])) {
                i = find(arr, i, sb);
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    
    private int find(char[] arr, int i, StringBuilder res) {
        StringBuilder sb = new StringBuilder();
        int k = arr[i++] - '0';
        while (arr[i] != '[') {
            k = (k * 10) + (arr[i++] - '0');
        }
        i++;
        while (i < arr.length) {
            if (isNumber(arr[i])) {
                i = find(arr, i, sb);
            } else if (arr[i] == ']') {
                String str = sb.toString();
                int repeat = 0;
                while (repeat++ < k) {
                    res.append(str);
                }
                return i;
            } else {
                sb.append(arr[i]);
            }
            i++;
        }
        return i;
    }
    
    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}
