package in.barmans.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * A street of n houses. You need to paint all the houses with either G,B,R. The
 * cost of painting any of the houses with each of these colors is given. You
 * need to find the minimum cost for paiting all the hoyses subject to condition
 * that no two adjacent houses can have the same colour.
 * 
 * For Example - G[] = [2,3,6] B[] = [4,7,8] R[] = [5,7,7] == 14
 * 
 * Cost of painting 1st house with Green is 2 Cost of painting 1st house with
 * Green is 3 Cost of painting 1st house with Green is 6
 * 
 * Cost of painting 1st house with Blue is 4 Cost of painting 1st house with
 * Blue is 7 Cost of painting 1st house with Blue is 8 ----
 * 
 * 
 * 
 * //
 * 
 * 1, 2 3, 1
 * 
 * min = getCost(arr, -1, 0)
 * 
 * @author mbarman
 *
 */
public class GrouponTest {
	public static void main(String[] args) {
		int[][] arr = { { 7, 1}, { 3,4 } };

		System.out.println(getCost(arr, -1, 0));
	}

	private static Map<String, Integer> map = new HashMap<>();
	private static int min = Integer.MAX_VALUE;// min value initialization bug

	static int getCost(int[][] arr, int usedColor, int houseIndex) {
		if (arr == null)
			return 0;// throw exception
		if (usedColor >= arr.length)
			return 0;
		if (houseIndex >= arr[0].length || houseIndex < 0)
			return 0;

		for (int colorIndex = 0; colorIndex < arr.length; colorIndex++) { // for loop end case bug
			if (usedColor != colorIndex) {
				int cost = arr[colorIndex][houseIndex];
				int restHouseCost;
				if (map.containsKey(colorIndex + "_" + houseIndex + 1)) {
					restHouseCost = map.get(colorIndex + "_" + houseIndex + 1);
				} else {
					restHouseCost = getCost(arr, colorIndex, houseIndex + 1);
				}

				int totalCost = cost + restHouseCost;
				map.put(colorIndex + "_" + houseIndex, totalCost);
				if (min > totalCost) {
					min = totalCost;
				}
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min; // check if the Initialized value is still
	}

	/**
	 * Diameter of a tree-
	 */

	public int findDiameter(Node root) {
		if (root == null)
			return 0;

		int leftMaxDiameter = findDiameter(root.left);
		int rightMaxDiameter = findDiameter(root.right);

		int leftLen = getLen(root.left);
		int rightLen = getLen(root.right);

		return Math.max((leftLen + rightLen + 1), Math.max(leftMaxDiameter, rightMaxDiameter));

	}

	private int getLen(Node node) {
		if (node == null)
			return 0;
		int leftLen = getLen(node.left);
		int rightLen = getLen(node.right);
		return Math.max(leftLen, rightLen) + 1;
	}

}
