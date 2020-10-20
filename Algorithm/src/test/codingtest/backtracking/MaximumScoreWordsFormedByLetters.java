package test.codingtest.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumScoreWordsFormedByLetters {
	public static void main(String[] args) {
		String[] words;
		char[] letters;
		int[] score;
		Scanner scan = new Scanner(System.in);
		
		String data = scan.next();
		data = data.replace("[", "").replace("]", "").replace("\"", "");
		words = data.split(",");
		
		data = scan.next();
		data = data.replace("[", "").replace("]", "").replace("\"", "").replace(",", "");
		letters = data.toCharArray();
		
		data = scan.next();
		data = data.replace("[", "").replace("]", "").replace("\"", "");
		score = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
		
		int res = new MaximumScoreWordsFormedByLetters().maxScoreWords(words, letters, score);
		System.out.println("res --> " + res);
	}
	
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letMap = new int[26];
        for (int i = 0; i < letters.length; i++) {
            letMap[letters[i] - 'a']++;
        }
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i].toCharArray());
        }
        int res = 0;
//        for (int i = 0; i < list.size(); i++) {
            int max = findMaximum(list, 0, letMap, score);
            res = Math.max(res, max);
//        }
        return res;
    }
    
    private int findMaximum(List<char[]> list, int idx, int[] letMap, int[] score) {
        if (idx >= list.size()) {
            return 0;
        }
        int res = 0;
        for (int k = idx; k < list.size(); k++) {
            char[] target = list.get(k);
            int[] cloneMap = letMap.clone();
            int sum = 0;
            for (int i = 0; i < target.length; i++) {
                int chIdx = (target[i] - (int)'a');
                // System.out.println(String.valueOf(target) + "," + target[i] + "," + chIdx + "," + cloneMap[chIdx]);
                if (cloneMap[chIdx] == 0) {
                    sum = 0;
                    break;
                }
                cloneMap[chIdx]--;
                sum += score[chIdx];
            }
            if (sum != 0) {
                sum += findMaximum(list, k + 1, cloneMap, score);
                res = Math.max(res, sum);
                // System.out.println(String.valueOf(target) +", res = " +res);
            }
        }
        return res;
    }	
}
