package in.barmans.practice;

public class Fibonacci {

	static long memo[];

	public static void main(String[] args) {
		int n = 100;
		memo = new long[n + 1];
		for (int i = 0; i < n + 1; i++) {
			memo[i] = -1;
		}
		System.out.println(fDyn(n));

	}

	static long fRec(long n) {
		if (n <= 1) {
			return 1;
		}

		return fRec(n - 1) + fRec(n - 2);
	}

	static long fDyn(int n) {
		if (n <= 1) {
			return 1;
		}

		if (memo[n] != -1) {
			// noop
		} else {
			memo[n] = fDyn(n - 1) + fDyn(n - 2);
		}
		return memo[n];

	}

}
