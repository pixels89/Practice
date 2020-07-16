package in.barmans.practice;

public class HighLow {
	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 8, 8, 8 };
		int[] highLow = highLow(a, 8);
		System.out.println(highLow[0] + " " + highLow[1]);
	}

	private static int[] highLow(int[] a, int n) {
		int[] result = new int[2];
		result[0] = low(a, n);
		result[1] = high(a, n);
		return result;
	}

	private static int high(int[] a, int n) {
		int l = 0;
		int r = a.length - 1;

		int mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (a[mid] == n) {
				if (mid == a.length - 1)
					return a.length - 1;
				if (a[mid] < a[mid + 1]) {
					return mid;
				} else {
					l = mid + 1;
				}
			} else if (a[mid] < n) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}

		}

		return -1;
	}

	private static int low(int[] a, int n) {

		int l = 0;
		int r = a.length - 1;

		int mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (a[mid] == n) {
				if (mid == 0)
					return 0;
				if (a[mid - 1] < a[mid])
					return mid;
				else
					r = mid - 1;

			} else if (a[mid] < n) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return -1;
	}
}
