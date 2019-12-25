package in.barmans.practice;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

	public static List<Integer> findDuplicates(int[] nums) {
		int n;
		int valAtIndex;
		List<Integer> ans = new ArrayList<Integer>();
		// [4,3,2,7,8,2,3,1]
		// idea here we iterate the num array and mark the value at num[num[i]] to be
		// negative, if we see any negative value while iteration it means we have
		// already visited it
		for (int i = 0; i < nums.length; i++) {
			n = nums[i];
			n = Math.abs(n);
			valAtIndex = nums[n - 1];
			if (valAtIndex > 0) {
				nums[n - 1] = -1 * valAtIndex;
			} else {
				ans.add(n);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> list = findDuplicates(a);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
