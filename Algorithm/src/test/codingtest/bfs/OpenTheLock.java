package test.codingtest.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class OpenTheLock {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		String target = scan.next();
		String[] deadends = in1.replace("[", "").replace("]", "").replace("\"", "").split(",");
		System.out.println("result -> " + new OpenTheLock().openLock(deadends, target));
	}

	public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        
        String lock = "0000";
        if (dead.contains(lock)) {
            return -1;
        }
        
        Queue<String> que = new ArrayDeque<>();
        que.add("0000");
        dead.add("0000");
        int step = 0;
        while (!que.isEmpty()) {
            step++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String pw = que.poll();
                if (target.equals(pw)) {
                    return step - 1;
                }
                getPassword(dead, que, pw);
            }
        }
        return -1;
    }
    
    private void getPassword(Set<String> dead, Queue<String> que, String pw) {
        
        char[] arr = pw.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            
            char ch = arr[i];
            
            if (ch == '9') {
                arr[i] = '0';
            } else {
                arr[i] = (char)((int)ch + 1);
            }
            String temp = String.valueOf(arr);
            if (!dead.contains(temp)) {
                dead.add(temp);
                que.add(temp);
            }
            if (ch == '0') {
                arr[i] = '9';
            } else {
                arr[i] = (char)((int)ch - 1);
            }
            temp = String.valueOf(arr);
            if (!dead.contains(temp)) {
                dead.add(temp);
                que.add(temp);
            }
            arr[i] = ch;
        }
    }
}
