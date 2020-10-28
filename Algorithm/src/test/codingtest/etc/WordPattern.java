package test.codingtest.etc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordPattern {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String pattern = scan.nextLine();
		String s = scan.nextLine();
		System.out.println("result -> " + new WordPattern().wordPattern(pattern, s));
	}

	
	public boolean wordPattern(String pattern, String s) {
        char[] p = pattern.toCharArray();
        String[] arr = s.split(" ");
        if (p.length != arr.length) return false;
        
        String[] map = new String[26];
        Set<String> befStr = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int mapIdx = p[i] - 'a';
            if (map[mapIdx] == null) {
                if (befStr.contains(arr[i])) return false;
                map[mapIdx] = arr[i];
                befStr.add(map[mapIdx]);
            } else {
                if (!map[mapIdx].equals(arr[i])) return false;
            }
        }
        return true;
    }
}
