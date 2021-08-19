package test.pointer;

public class UniqueLength3PalindromicSubseq {

	// *****
	// leetCode.Unique Length-3 Palindromic Subsequence
	// Using pointer
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countPalindromicSubsequence(String s) {
        boolean[] used = new boolean[26];
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (used[arr[i] - 'a']) {
                continue;
            }
            used[arr[i] - 'a'] = true;
            int lastIdx = arr.length - 1;
            while (lastIdx > i) {
                if (arr[lastIdx] == arr[i]) {
                    break;
                }
                lastIdx--;
            }
            boolean[] usedSubseq = new boolean[26];
            for (int x = i + 1; x < lastIdx; x++) {
                if (!usedSubseq[arr[x] - 'a']) {
                    res++;
                    usedSubseq[arr[x] - 'a'] = true;
                }
            }
        }
        return res;
    }
}
