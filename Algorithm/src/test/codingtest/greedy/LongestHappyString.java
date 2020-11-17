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
		int[] aa = {(int)'a', a};
		int[] bb = {(int)'b', b};
		int[] cc = {(int)'c', c};
		Queue<int[]> que = new PriorityQueue<>((o1, o2)->{
			return ((int[]) o2)[1] - ((int[]) o1)[1];
		});
		if (a > 0) que.add(aa);
		if (b > 0) que.add(bb);
		if (c > 0) que.add(cc);
		
		int[] bef = null;
		while (!que.isEmpty()) {
			int[] thisChar = que.poll();
			String tmp = "" + (char)thisChar[0];
			tmp += tmp;
			if (s.length() >= 2 && s.toString().endsWith(tmp)) {
				bef = thisChar;
				continue;
			}
			s.append((char)thisChar[0]);
			thisChar[1]--;
			if (thisChar[1] > 0) que.add(thisChar);
			if (bef != null) {
				que.add(bef);
				bef = null;
			}
		}
		
        return s.toString();
    }
}

