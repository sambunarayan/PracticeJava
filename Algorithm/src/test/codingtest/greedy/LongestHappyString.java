package test.codingtest.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * leetcode 1405.Longest Happy String
 * 
 * Java greedy approach using priority queue
 *
 */
public class LongestHappyString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		String res = new LongestHappyString().longestDiverseString(a, b, c);
		System.out.println("result -> " + res);
	}
	public String longestDiverseString(int a, int b, int c) {
		StringBuilder s = new StringBuilder(a + b + c);
		Pair aP = new Pair('a', a);
		Pair bP = new Pair('b', b);
		Pair cP = new Pair('c', c);
		Queue<Pair> que = new PriorityQueue<>(new PairComparator());
		if (a > 0) que.add(aP);
		if (b > 0) que.add(bP);
		if (c > 0) que.add(cP);
			
		while (que.size() > 1) {
			int bef = 1;
			int print = 0;
			while (print < 2) {
				Pair p = que.poll();
				if (s.toString().endsWith(""+p.key)) {
					if (!que.isEmpty()) p = que.poll();
				}
				int cnt = (p.val / 2 > 0) ? 2 : 1;
				for (int i = 0; i < cnt && p.val > 0; i++) {
					s.append(p.key);
					p.val--;
				}
				bef = p.val;
				print++;
			}
			if (aP.val > 0) que.add(aP);
			if (bP.val > 0) que.add(bP);
			if (cP.val > 0) que.add(cP);
		}
		if (!que.isEmpty()) {
			Pair p = que.poll();
			if (!s.toString().endsWith(""+p.key)) {
				for (int i = 0; i < 2 && p.val > 0; i++) {
					s.append(p.key);
					p.val--;
				}
			}
		}
		
        return s.toString();
    }
	
	class Pair {
		char key;
		Integer val;
		
		Pair(char key, Integer val) {
			this.key = key;
			this.val = val;
		}
	}
	
	class PairComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {
			return o2.val.compareTo(o1.val);
		}
		
	}
}

