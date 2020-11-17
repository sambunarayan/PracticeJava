package test.codingtest.etc;

import java.util.Arrays;
import java.util.Scanner;

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
        for (int left = 0, right = people.length - 1; left <= right; right--) {
            boat++;
            if (people[left] + people[right] <= limit) {
                left++;
            }
        }
        
        return boat;
    }
}
