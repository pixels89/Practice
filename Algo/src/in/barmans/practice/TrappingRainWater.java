package in.barmans.practice;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * @author mbarman
 *
 */
public class TrappingRainWater {
	static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

	public static void main(String[] args) {
		System.out.println("Maximum water that can be accumulated is " + findWaterEfficient(arr));
	}

	private static int findWater(int[] arr) {

		int n = arr.length;

		int[] left = new int[arr.length];
		int[] right = new int[arr.length];

		left[0] = arr[0];
		for (int i = 1; i < left.length; i++) {
			left[i] = (arr[i] > left[i - 1]) ? arr[i] : left[i - 1];
		}

		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i > 0; i--) {
			right[i] = (arr[i] > right[i + 1]) ? arr[i] : right[i + 1];
		}

		int water = 0;

		for (int i = 0; i < arr.length; i++) {
			water += Math.min(left[i], right[i]) - arr[i];
		}

		return water;
	}

	private static int findWaterEfficient(int[] arr) {

		int start = 0;
		int end = arr.length - 1;
		int leftMax = 0, rightMax = 0;
		int water = 0;
		while (start <= end) {
			if (arr[start] < arr[end]) {
				if (leftMax < arr[start]) {
					leftMax = arr[start];
				} else {
					water += (leftMax - arr[start]);
				}
				start++;
			} else {
				if (rightMax < arr[end]) {
					rightMax = arr[end];
				} else {
					water += (rightMax - arr[end]);
				}
				end--;
			}

		}
		return water;
	}
}
