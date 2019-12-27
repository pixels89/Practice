package in.barmans.dp;

class LIConsecutive {

	public static void main(String[] args) {
		int A[] = { 2, 5, 3, 7, 4, 8, 5, 13, 6 };

		System.out.println(findLIS(A));
	}

	private static int findLIS(int[] a) {
		return findLIS(a, a[0] - 1, 0);
	}

	private static int findLIS(int[] a, int prev, int i) {
		if (i >= a.length)
			return 0;

		int notUsing = findLIS(a, prev, i + 1);
		if (a[i] == prev + 1) {
			int using = 1 + findLIS(a, a[i], i + 1);
			return Math.max(using, notUsing);
		}

		return notUsing;
	}
}