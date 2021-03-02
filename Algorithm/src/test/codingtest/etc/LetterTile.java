package test.codingtest.etc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LetterTile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		new LetterTile().numTilePossibilities(in1);
	}
	
	public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(char c : tiles.toCharArray()) freq[c-'A']++;
        return numUtil(freq, 0);
        
    }
    public int numUtil(int[] freq, int count){
        for(int i = 0; i<26; i++){
            if(freq[i]==0) continue;
            else{
                freq[i]--;
                count = numUtil(freq, count+1);
                freq[i]++;
            }
        }
        return count;
    }


}
