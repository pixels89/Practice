package in.barmans.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BacktrackingBraces {

	public static void main(String[] args) {
		long start = System.nanoTime();
		List<String> acc = allPossibleBraces(13);
		System.out.println(acc.size());
		long end = System.nanoTime();
		System.out.println(end-start);
		for (String string : acc) {
			//System.out.println(string);
		}
	}

	private static List<String> allPossibleBraces(int n) {
		List<String> acc = new ArrayList<String>();
		StringBuilder current = new StringBuilder();
		int countO = 0;
		int countC = 0;
		current.append("{");
		countO = 1;
		allPossibleBraces(current, countO, countC, n, acc);

		return acc;
	}

	private static void allPossibleBraces(StringBuilder current, int countO, int countC, int n, List<String> acc) {
		if (current.length() == n * 2) {
			acc.add(current.toString());
			return;
		}
		List<Character> chs = getAllPossiblities(countO, countC, n);
		for (Character ch : chs) {
			if (ch == '{') {
				countO++;
			} else {
				countC++;
			}
			current.append(ch);
			allPossibleBraces(current, countO, countC, n, acc);
			current.deleteCharAt(current.length() - 1);
			if (ch == '{') {
				countO--;
			} else {
				countC--;
			}
		}
	}

	private static List<Character> getAllPossiblities(int countO, int countC, int n) {
		List<Character> posiibilities = new LinkedList<Character>();
		if (countO < n) {
			posiibilities.add('{');
		}
		if (countC < countO) {
			posiibilities.add('}');
		}
		return posiibilities;
	}
}
