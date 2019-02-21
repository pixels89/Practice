package in.barmans.practice;

/**
 * Given two sequences, find the length of longest subsequence present in both
 * of them. A subsequence is a sequence that appears in the same relative order,
 * but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”,
 * ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has
 * 2^n different possible subsequences.
 * 
 * @author mbarman
 *
 */
public class LCS {
	static int[][] memo;

	public static void main(String args[]) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		int lcsLen = getLCS(str1, str2);
		System.out.printf("LCS of %s and %s is %d\n", str1, str2, lcsLen);
	}

	private static int getLCS(String s1, String s2) {
		memo = new int[s1.length()][s2.length()];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				memo[i][j] = -1;
			}
		}
		return getLCSDynamic(s1, s1.length() - 1, s2, s2.length() - 1);
	}

	private static int getLCSInternalRec(String str1, int index1, String str2, int index2) {
		if (index1 < 0 || index2 < 0) {
			return 0;
		}
		if (str1.charAt(index1) == str2.charAt(index2)) {
			return 1 + getLCSInternalRec(str1, index1 - 1, str2, index2 - 1);
		} else {
			int v1 = getLCSInternalRec(str1, index1 - 1, str2, index2);
			return Math.max(v1, getLCSInternalRec(str1, index1, str2, index2 - 1));
		}

	}

	private static int getLCSDynamic(String s1, int i1, String s2, int i2) {

		if (i1 < 0 || i2 < 0) {
			return 0;
		}

		if (memo[i1][i2] != -1) {
			// noop
		} else if (s1.charAt(i1) == s2.charAt(i2)) {
			memo[i1][i2] = 1 + getLCSDynamic(s1, i1 - 1, s2, i2 - 1);
		} else {
			memo[i1][i2] = Math.max(getLCSDynamic(s1, i1 - 1, s2, i2), getLCSDynamic(s1, i1, s2, i2 - 1));
		}

		return memo[i1][i2];
	}
}
