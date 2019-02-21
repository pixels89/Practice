package in.barmans.practice;

/**
 * Given two strings str1 and str2 and below operations that can performed on
 * str1. Find minimum number of edits (operations) required to convert ‘str1’
 * into ‘str2’.
 * 
 * Insert Remove Replace 
 * All of the above operations are of equal cost.
 * 
 * @author mbarman
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		String EXECUTION = "EXE";
		String INTENTION = "INTE";
		int editDistance = minEditDistance(INTENTION, INTENTION.length() - 1, EXECUTION, EXECUTION.length() - 1);
		System.out.println(editDistance);
	}

	// ab c
	// ab e
	static int minEditDistance(String s1, int i1, String s2, int i2) {

		if (i1 < 0) {
			return i2 >= 0 ? i2 + 1 : 0;
		} else if (i2 < 0) {
			return i1 >= 0 ? i1 + 1 : 0;
		} else if (s1.charAt(i1) == s2.charAt(i2)) {
			return minEditDistance(s1, i1 - 1, s2, i2 - 1);
		} else {
			return Math.min(Math.min(1 + minEditDistance(s1, i1, s2, i2 - 1), 1 + minEditDistance(s1, i1 - 1, s2, i2)),
					1 + minEditDistance(s1, i1 - 1, s2, i2 - 1));
		}

	}

}
