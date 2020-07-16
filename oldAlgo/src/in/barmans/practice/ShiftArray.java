package in.barmans.practice;

public class ShiftArray {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] out = shiftReverse(a, 5);
		for (int i = 0; i < out.length; i++) {
			System.out.print(out[i] + " ");
		}
		System.out.println(binarySearchRotate(a, 5));
	}

	private static int[] shiftArray(int[] a, int k) {
		int nLoc;
		int pLoc;

		int count = 0;
		for (int i = 0; count < a.length; i++) {
			pLoc = i;
			int pVal = a[pLoc];
			do {
				nLoc = ((pLoc - k) + a.length) % a.length;
				int temp = a[nLoc];
				a[nLoc] = pVal;
				pLoc = nLoc;
				pVal = temp;
				count++;
			} while (i != pLoc);
		}
		return a;
	}

	private static void reverse(int[] a, int l, int r) {
		while (l < r) {
			int temp = a[l];
			a[l] = a[r];
			a[r] = temp;

			l++;
			r--;
		}
	}

	private static int[] shiftReverse(int[] a, int k) {
		// int pivot = getPivot(a);
		reverse(a, 0, a.length - 1);

		int pivot = k;
		reverse(a, 0, pivot);

		reverse(a, pivot + 1, a.length - 1);
		return a;
	}

	private static int binarySearchRotate(int[] a, int k) {
		if (a[0] > a[a.length - 1]) {
			int pivot = getPivot(a);
			System.out.println("pivot: " + pivot);
			if (a[0] <= k) {
				return binarySearchSimple(a, 0, pivot, k);
			}
			return binarySearchSimple(a, pivot + 1, a.length - 1, k);
		}
		return binarySearchSimple(a, 0, a.length - 1, k);
	}

	private static int binarySearchSimple(int[] a, int l, int r, int k) {
		int mid = 0;
		while (l <= r) {
			mid = (l + r) / 2;
			if (a[mid] == k) {
				return mid;
			} else if (a[mid] < k) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	// 1 2 3
	private static int getPivot(int[] a) {
		int l = 0;
		int r = a.length - 1;
		int mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (a[mid] > a[mid + 1]) {
				return mid;
			} else if (a[l] <= a[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}
