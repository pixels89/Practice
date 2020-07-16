package in.barmans.practice;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

	public static boolean isMatch(String str, String pat) {
		Map<Character, String> map = new HashMap<>();
		return isMatch(str, 0, pat, 0, map);
	}

	public static boolean isMatch(String str, int strP, String pat, int patP, Map<Character, String> map) {
		if (strP == str.length() && patP == pat.length())
			return true;
		if (strP == str.length() || patP == pat.length())
			return false;

		char patCh = pat.charAt(patP);

		if (map.containsKey(patCh)) {
			String s = map.get(patCh);

			// then check if we can use it to match str[i...i+s.length()]
			if (strP + s.length() > str.length() || !str.substring(strP, strP + s.length()).equals(s)) {
				return false;
			}

			return isMatch(str, strP + s.length(), pat, patP + 1, map);
		}

		for (int i = strP; i < str.length(); i++) {
			map.put(patCh, str.substring(strP, i + 1));

			if (isMatch(str, i + 1, pat, patP + 1, map)) {
				map.remove(patCh);
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("mkehbarman", "lop"));
	}
}