package test.codingtest.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CombinationSum2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		int target = Integer.parseInt(scan.next());
		String[] arr = in1.replace("[", "").replace("]", "").replace("\"", "").split(",");
		int[] candidates = Arrays.stream(arr).mapToInt(s->Integer.parseInt(s)).toArray();
		System.out.println("result -> " + new CombinationSum2().combinationSum2(candidates, target));

	}
	List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        
        Stack<Integer> stack = new Stack<>();
        sum(candidates, target, 0, stack);
        return res;
    }
    
    private void sum(int[] candidates, int target, int idx, Stack<Integer> stack) {
        if (target == 0) {
            // System.out.println("exist -> " + exist + ", stack ->" + stack);
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = idx; i < candidates.length && candidates[i] <= target; i++) {
            if (i > idx && candidates[i - 1] == candidates[i]) {
                continue;
            }
            stack.push(candidates[i]);
            sum(candidates, target - candidates[i], i + 1, stack);
            stack.pop();
        }
    }
}
