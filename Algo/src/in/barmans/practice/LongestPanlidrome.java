package in.barmans.practice;

/**
 * Given a sequence, find the length of the longest palindromic subsequence in
 * it.
 * 
 * longest-palindromic-subsequence
 * 
 * As another example, if the given sequence is “BBABCBCAB”, then the output
 * should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. “BBBBB”
 * and “BBCBB” are also palindromic subsequences of the given sequence, but not
 * the longest ones.
 * 
 * @author mbarman
 *
 */

public class LongestPanlidrome {

	private static int checkParlindrome(String str, int s, int e) {
		if (s >= e) {
			return 1;
		}
		if (str.charAt(s) == str.charAt(e)) {
			return 2 + checkParlindrome(str, s + 1, e - 1);
		} else {
			return Math.max(checkParlindrome(str, s + 1, e), checkParlindrome(str, s, e - 1));
		}
	}

	private static int checkParlindrome(String s) {

		return checkParlindrome(s, 0, s.length() - 1);
	}

	public static void main(String[] args) {

		System.out.println(checkParlindrome("BBABCBCAB"));
		System.out.println(checkParlindrome("aa"));
		System.out.println(checkParlindrome("ab"));
		System.out.println(checkParlindrome("abab"));

	}

}
