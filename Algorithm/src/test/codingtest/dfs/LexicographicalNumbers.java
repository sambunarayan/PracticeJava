package test.codingtest.dfs;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	// *****
	// leetCode.386 Lexicographical Numbers
	// Using DFS algorithm.
	// I can use compare sort. But, DFS is more fast than compare sort.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			add(n, i, list);
		}
		return list;
	}

	public void add(int n, int num, List<Integer> list) {
		if (num > n) {
			return;
		}
		list.add(num);
		for (int i = 0; i <= 9; i++) {
			add(n, (num * 10) + i, list);
		}
	}
}
