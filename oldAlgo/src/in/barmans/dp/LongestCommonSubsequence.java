package in.barmans.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, 0 , 0));
	}

	private int lcs(char[] xs, char[] ys, int i, int j) {
		if (i >= xs.length) {
			return 0 ;
		}
		if (j >= ys.length) {
			return 0 ;
		}
		
		if (xs[i] == ys[j]) {
			return 1 + lcs(xs, ys, i + 1, j + 1);
		}
		return Math.max(lcs(xs, ys, i + 1, j), lcs(xs, ys, i, j + 1));

	}

}