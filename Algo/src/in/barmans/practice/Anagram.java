package in.barmans.practice;

/**
 * 
 * @author mbarman
 *
 */
public class Anagram {

	public static void main(String[] args) {
		String s1 = "abcdw";
		String s2 = "habcd";

		System.out.println(minChangeAnagram(s1, s2));

	}

	private static int minChangeAnagram(String s1, String s2) {
		int[] charArray1 = new int[26];
		int[] charArray2 = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			int charI = s1.charAt(i);

			charArray1[charI - 'a'] += 1;
		}

		for (int i = 0; i < s2.length(); i++) {
			int charI = s2.charAt(i);

			charArray2[charI - 'a'] += 1;
		}

		int change = 0;
		for (int i = 0; i < charArray1.length; i++) {
			change += Math.abs(charArray1[i] - charArray2[i]);
		}
		return change;
	}

}
