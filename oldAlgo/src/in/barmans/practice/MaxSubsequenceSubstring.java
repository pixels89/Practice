package in.barmans.practice;

/**
 * Given two string X and Y. The task is to find the length of longest
 * subsequence of string X which is substring in sequence Y.
 * 
 * Examples:
 * 
 * Input : X = "ABCD", Y = "BACDBDCD" Output : 3 "ACD" is longest subsequence of
 * X which is substring of Y.
 * 
 * Input : X = "A", Y = "A" Output : 1
 * 
 * @author mbarman
 *
 */
public class MaxSubsequenceSubstring {
	public static void main(String[] args) {
		char x[] = "ABCD".toCharArray();
		char y[] = "BACDBDCD".toCharArray();
		int n = x.length, m = y.length;
		System.out.println(maxSubsequenceSubstring(x, y, n, m));
	}

	private static int maxSubsequenceSubstring(char[] x, char[] y, int n, int m) {
		int[][] memo = PracticeUtil.initMemo(n+1, m+1, 0);

		for (int j = 1; j <= m; j++) {
			for (int i = 1; i <= n; i++) {
				if (x[i-1] == y[j-1]) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= m; i++) {
			max = Math.max(max, memo[n][i]);
		}

		return max;
	}
}
