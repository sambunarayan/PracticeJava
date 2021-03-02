package test.codingtest.etc;

import java.util.HashMap;
import java.util.Map;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countSubstrings(String s) {
		char[] ch = s.toCharArray();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < ch.length; i++) {
			find(ch, String.valueOf(ch[i]), i + 1, map);
		}
		Integer sum = map.values().stream().mapToInt(Integer::intValue).sum();
		return sum - 1;
	}

	private void find(char[] ch, String str, int idx, Map<String, Integer> map) {
		map.merge(str, 1, (v1, v2) -> v1 + v2);
		for (int i = idx; i < ch.length - 1; i++) {
			find(ch, str + ch[i], i + 1, map);
		}
	}

}
