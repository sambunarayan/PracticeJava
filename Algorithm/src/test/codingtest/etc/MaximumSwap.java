package test.codingtest.etc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MaximumSwap {
	
	// leetCode.670 Maximum Swap
	// Use Comparator and PriorityQueue

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println("res -> " + new MaximumSwap().maximumSwap(num));
	}
	
	public int maximumSwap(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        Queue<Pair> que = new PriorityQueue<>(new PairComp());
        
        for (int i = 0; i < ch.length; i++) {
            que.add(new Pair(i, ch[i]));
        }
        
        char thisN = ' ';
        int maxIdx = -1;
        int idx = 0;
        while (!que.isEmpty()) {
            Pair p = que.poll();
            if (thisN != p.value)  {
                thisN = p.value;
                maxIdx = p.idx;
            }
            // System.out.println(p.idx + "," + p.value);
            if (p.value != ch[idx]) {
                ch[maxIdx] = ch[idx];
                ch[idx] = p.value;
                return Integer.parseInt(String.valueOf(ch));
            }
            idx++;
        }
        
        return num;
    }
    
    class Pair {
        int idx;
        char value;
        public Pair(int idx, char ch) {
            this.idx = idx;
            this.value = ch;
        }
    }
    
    class PairComp implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.value > p2.value) {
                return -1;
            } else if (p1.value < p2.value) {
                return 1;
            } else {
                if (p1.idx < p2.idx) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
