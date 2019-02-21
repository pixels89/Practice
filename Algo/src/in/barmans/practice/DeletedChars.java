package in.barmans.practice;

import java.util.HashSet;
import java.util.Set;

public class DeletedChars {

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "ab";
		System.out.println(deletedChars(s1, s1.length() - 1, s2, s2.length() - 1));
	}

	static Set<Character> deletedChars(String s1, int i1, String s2, int i2) {
		if (i1 < 0) {
			return (i2 >= 0) ? toCharSet(s2.substring(0, i2 + 1).toCharArray()) : new HashSet<Character>();
		} else if (i2 < 0) {
			return (i1 >= 0) ? toCharSet(s1.substring(0, i1 + 1).toCharArray()) : new HashSet<Character>();
		} else if (s1.charAt(i1) == s2.charAt(i2)) {
			return deletedChars(s1, i1 - 1, s2, i2 - 1);
		} else {
			Set<Character> deletedChars1 = new HashSet<Character>();
			Set<Character> deletedChars2 = new HashSet<Character>();
			if (i1 > 0) {
				deletedChars1 = deletedChars(s1, i1 - 1, s2, i2);
				deletedChars1.add(s1.charAt(i1));
			}
			if (i2 > 0) {
				deletedChars2 = deletedChars(s1, i1, s2, i2 - 1);
				deletedChars2.add(s2.charAt(i2));

			}
			deletedChars1.addAll(deletedChars2);
			return deletedChars1;
		}
	}

	private static Set<Character> toCharSet(char[] charArray) {
		Set<Character> resultSet = new HashSet<Character>();

		for (char character : charArray) {
			resultSet.add(character);
		}
		return resultSet;
	}

}
