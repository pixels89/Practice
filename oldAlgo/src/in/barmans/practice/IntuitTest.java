package in.barmans.practice;

public class IntuitTest {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 2 };

		arr = sort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.println(i);
		}

	}

	private static void printSumPairs(int[] arr, int sum) {

		if (arr == null)
			return;

		int start = 0;
		int end = arr.length - 1;

		while (end > start) {
			if (arr[end] + arr[start] == sum) {
				System.out.println("Pair found: " + arr[start] + " " + arr[end]);
				end--;
				start++;
			} else if (arr[end] + arr[start] > sum) {
				end--;
			} else {
				start++;
			}
		}

	}

	private static int[] sort(int[] arr, int start, int end) {
		if (end < start) {
			return null;
		}

		if (end - start == 0) {
			int[] arr1 = new int[1];
			arr1[0] = arr[end];
			return arr1;
		}

		int mid = (start + end) / 2;
		int[] left = sort(arr, start, mid);

		int[] right = sort(arr, mid + 1, end);

		int[] result = merge(left, right);
		return result;
	}

	private static int[] merge(int[] left, int[] right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		int[] result = new int[left.length + right.length];

		int leftpt = 0;
		int rightptr = 0;
		for (int i = 0; i < result.length; i++) {

			int val = 0;
			if (leftpt < left.length && rightptr < right.length)
				val = (left[leftpt] < right[rightptr]) ? left[leftpt++] : right[rightptr++];

			else if (leftpt >= left.length)
				val = right[rightptr++];

			else if (rightptr >= right.length)
				val = left[leftpt++];

			result[i] = val;
		}

		return result;
	}

}
