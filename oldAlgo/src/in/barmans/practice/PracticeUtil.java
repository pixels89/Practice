package in.barmans.practice;

public class PracticeUtil {
	public static int[][] initMemo(int rows, int cols, int defaultVal) {
		int[][] memo = new int[rows][cols];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				memo[i][j] = defaultVal;
			}
		}
		return memo;
	}

}
