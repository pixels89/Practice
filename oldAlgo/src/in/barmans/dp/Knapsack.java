package in.barmans.dp;

public class Knapsack {

	public static void main(String[] args) {
		int[] p = { 4, 5, 3, 7 };
		int[] w = { 2, 3, 1, 4 };
		int limit = 5;

		System.out.println(profit(w, p, limit, 0));

	}

	static int profit(int[] w, int[] p, int limit, int index) {

		if (limit <= 0)
			return 0;

		if (index < w.length) {
			int res = Math.max(p[index] + profit(w, p, limit - w[index], index + 1), profit(w, p, limit, index + 1));
			System.out.printf("called with %s %s\n", limit, index);

			System.out.println(res);
			return res;
		} else
			return 0;
	}

}
