package in.barmans.practice;

public class RotatedArray {

	private static int findElement(int[] arr, int k) {
		if (arr == null || arr.length == 0)
			return -1;

		int st = 0;
		int end = arr.length - 1;

		while (st <= end) {
			int mid = (st + end) / 2;

			if (arr[mid] == k) {
				return mid;
			}

			else if (arr[st] <= arr[mid]) {
				if (arr[st] <= k && k <= arr[mid]) {
					end = mid - 1;
				} else {
					st = mid + 1;
				}
			} else {
				if (arr[mid] <= arr[end]) {
					if (arr[mid] <= k && k <= arr[end]) {
						st = mid + 1;
					} else {
						end = mid - 1;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int [] test = {7,6,1,2,3,4,5};
		
		System.out.println(findElement(test, 6));
	}
}
