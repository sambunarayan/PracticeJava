package test.codingtest.etc;

import java.util.Map;
import java.util.TreeMap;

public class AdvantageShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> aNavi = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            if (aNavi.containsKey(A[i])) {
                aNavi.replace(A[i], aNavi.get(A[i]) + 1);
            } else {
                aNavi.put(A[i], 1);
            }
        }
        int[] res = new int[A.length];
        int i = 0;
        while (i < A.length) {
            Map.Entry<Integer, Integer> a = aNavi.tailMap(B[i], false).pollFirstEntry();
            if (a == null) {
                a = aNavi.pollFirstEntry();
            }
            res[i] = a.getKey();
            if (a.getValue() > 1) {
                aNavi.put(a.getKey(), a.getValue() - 1);
            }
            i++;
        }
        return res;
    }

}
