package test.codingtest.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BoatsToSavePeople {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		int limit = Integer.parseInt(scan.next());
		String[] arr = in1.replace("[", "").replace("]", "").split(",");
		int[] people = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).toArray();
		System.out.println("res -> " + new BoatsToSavePeople().numRescueBoats(people, limit));
	}
	public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        List<Integer> list = Arrays.stream(people).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toList());
        while (list.size() > 0) {
            boat++;
            int pp = (int) list.remove(list.size() -1);
            int lm = limit - pp;
            find(list, lm, 0);
        }
        return boat;
    }

    private int find(List<Integer> list, int limit, int idx) {
        if (list.size() <= 0) {
            return limit;
        } else if (idx >= list.size()) {
        	return limit;
        }
        if (list.get(idx) == limit) {
            list.remove(idx);  
            return 0;
        } else if (list.get(idx) < limit) {
            limit = find(list, limit, idx + 1);
            if (limit > 0 && list.size() > 0) {
                if (list.get(idx) <= limit) {
                    limit -= list.remove(idx);
                }
            }
            return limit;
        } else {
            return limit;
        }
    }
}
