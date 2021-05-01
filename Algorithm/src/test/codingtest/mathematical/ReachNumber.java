package test.codingtest.mathematical;

public class ReachNumber {
	
	// ***
	// leetCode.754 Reach a Number
	// Using BFS. But it failed because the time limit was exceeded.
	// 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int reachNumber(int target) {
	        target = Math.abs(target);
	        int step = 0;
	        while (target > 0) {
	            target -= ++step;
	        }
	        return target % 2 == 0 ? step : step + 1 + step % 2; 
	    }
	    
	    // public int reachNumber(int target) {
	    //     int step = 1;
	    //     int count = 0;
	    //     Queue<Integer> que = new ArrayDeque<>();
	    //     que.add(0 + step);
	    //     que.add(0 - step);
	    //     while (!que.isEmpty()) {
	    //         step++;
	    //         count++;
	    //         Queue<Integer> nextQue = new ArrayDeque<>();
	    //         while (!que.isEmpty()) {
	    //             int num = que.poll();
	    //             if (num == target) {
	    //                 nextQue = new ArrayDeque<>();
	    //                 break;
	    //             }
	    //             if (!nextQue.contains(num + step)) {
	    //                 nextQue.add(num + step);
	    //             }
	    //             if (!nextQue.contains(num - step)) {
	    //                 nextQue.add(num - step);
	    //             }
	    //         }
	    //         que = nextQue;
	    //     }
	    //     return count;
	    // }
	    
	}

}
