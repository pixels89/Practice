package in.barmans.practice;

public class GFG {
	static final int MAX = 9;

	// Return the maximum size of substring of
	// X which is substring in Y.
	static int maxSubsequenceSubstring(char x[], char y[], int n, int m) {
		int dp[][] = new int[MAX][MAX];

		// Initialize the dp[][] to 0.
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				dp[i][j] = 0;

		// Calculating value for each element.
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				// If alphabet of string X and Y are
				// equal make dp[i][j] = 1 + dp[i-1][j-1]
				if (x[j - 1] == y[i - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];

				// Else copy the previous value in the
				// row i.e dp[i-1][j-1]
				else
					dp[i][j] = dp[i][j - 1];
			}
			System.out.print("    ");
			for (char is : x) {
				System.out.print(is + " ");
			}
			System.out.println();
			printArray(dp, y);
			System.out.println();
		}

		// Finding the maximum length.
		int ans = 0;
		for (int i = 1; i <= m; i++)
			ans = Math.max(ans, dp[i][n]);

		return ans;
	}

	static void printArray(int[][] dArray, char[] y) {
		for (int j =0; j< dArray.length; j++) {
			int[]row = dArray[j];
			if (j >= 1 && j< y.length) {
				System.out.print(y[j-1] + " ");
				
			}
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i] + " ");
			}
			System.out.println();
		}
	}

	// Driver Method
	public static void main(String[] args) {
		char x[] = "ABCD".toCharArray();
		char y[] = "BACDBDCD".toCharArray();
		int n = x.length, m = y.length;
		System.out.println(maxSubsequenceSubstring(x, y, n, m));
	}
}