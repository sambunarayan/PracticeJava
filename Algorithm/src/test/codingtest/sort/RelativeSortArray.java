package test.codingtest.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RelativeSortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        Queue<Integer> remain = new PriorityQueue<>();
        for (int i : arr2) {
            map.put(i, 0);
        }
        for (int i : arr1) {
            Integer n = map.get(i);
            if (n != null) {
                map.replace(i, n + 1);  
            } else remain.add(i);
        }
        for (int i : arr2) {
            for (int k = 0; k < map.get(i); k++) {
                res[idx++] = i;    
            }
        }
        while (!remain.isEmpty()) {
            res[idx++] = remain.poll();
        }
        
        return res;
    }

}
