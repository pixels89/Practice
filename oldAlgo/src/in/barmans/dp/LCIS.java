package in.barmans.dp;

class LCIS {

	static private int lcis(int[] xs, int[] ys, int i, int j, int prev) {
		if (i >= xs.length) {
			return 0;
		}
		if (j >= ys.length) {
			return 0;
		}

		if (xs[i] == ys[j] && xs[i] > prev) {
			return Math.max(1 + lcis(xs, ys, i + 1, j + 1, xs[i]), lcis(xs, ys, i + 1, j + 1, prev));
		}
		return Math.max(lcis(xs, ys, i + 1, j, prev), lcis(xs, ys, i, j + 1, prev));

	}

	public static void main(String[] args) {
	

		int[] X = {3, 4, 9, 1};
		int[] Y = {5, 3, 8, 9, 10, 2, 1};

		System.out.println("Length of LCS is" + " " + lcis(X, Y, 0, 0, Integer.MIN_VALUE));
	}
}
