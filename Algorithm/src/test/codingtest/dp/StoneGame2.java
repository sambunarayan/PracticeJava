package test.codingtest.dp;

public class StoneGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] SUM;
    int[][] DP;
    public int stoneGameII(int[] piles) {
        int length = piles.length;
        DP = new int[length][2 * length];
        SUM = new int[length + 1];
        for(int i = 0; i < length; i++) {
            SUM[i + 1] = SUM[i] + piles[i];
        }
        return populateScore(piles, 0, 1);
    }

    private int populateScore(int[] piles, int startIndex, int M) {
        int length = piles.length;
        if(DP[startIndex][M] != 0) {
            return DP[startIndex][M];
        }
        if((length - startIndex) <= (2 * M)) {
            DP[startIndex][M] = SUM[length] - SUM[startIndex];
            return DP[startIndex][M];
        }
        int maxScore = SUM[length] - SUM[startIndex] - populateScore(piles, startIndex + 1, Math.max(M, 1));
        for(int i = (startIndex + 1); i <= (startIndex + 2 * M - 1) && i < length; i++) {
            maxScore = Math.max(maxScore, SUM[length] - SUM[startIndex] - populateScore(piles, i + 1, Math.max(M, i - startIndex + 1)));
        }
        DP[startIndex][M] = maxScore;
        return DP[startIndex][M];
    }

}
