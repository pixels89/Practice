package in.barmans.practice;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;


/**
 * get all jumping numbers
 * @author mbarman
 *
 */
public class JumpNumners {

	public static void main(String[] args) {
		System.out.println(getJumps(49900));
	}

	private static List<String> getJumps(int num) {
		int d = 0;
		int prev = 0;
		int temp = num;
		while (temp > 0) {
			d++;
			prev = temp;
			temp /= 10;
		}
		List<String> jumpsInternal = Lists.newArrayList();
		for (int i = 1; i <= prev; i++) {
			jumpsInternal.addAll(getJumpsInternal(i, d));
		}

		for (int j = d - 1; j >= 1; j--) {
			for (int i = 9; i > 0; i--) {
				jumpsInternal.addAll(getJumpsInternal(i, j));
			}
		}
		return jumpsInternal;
	}

	private static List<String> getJumpsInternal(int n, int d) {
		if (d == 0) {
			return null;
		} else if (d == 1)
			return Lists.newArrayList("" + n);

		List<String> jumps = new ArrayList<>();
		if (n != 0) {
			jumps.addAll(getJumpsInternal(n - 1, d - 1));
		}
		if (n != 9) {
			jumps.addAll(getJumpsInternal(n + 1, d - 1));
		}
		List<String> result = Lists.newArrayList();
		for (String integer : jumps) {
			result.add(n + integer);
		}
		return result;
	}

}
