package in.barmans.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.common.collect.Lists;



/**
 * Home work points in an array:
 * after completing i -> i+1 or i+2
 * happy if max point - min point >= threshold
 * 
 * return min homework if not possible return all
 * @author mbarman
 *
 */
class Result {

	private static int getHappiness(int currentHappiness, int max, int min, int val) {

		max = Math.max(max, val);
		min = Math.min(min, val);

		int happyness = max - min;

		return Math.max(currentHappiness, happyness);

	}
	/*
	 * Complete the 'minNum' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER threshold 2. INTEGER_ARRAY happy
	 */

	public static int minNum(int threshold, List<Integer> happy) {

		int currentHappiness = 0;
		int min = happy.get(0);
		int max = happy.get(0);
		int count = 1;

		int size = happy.size();
		int i = 1;
		while (i < size) {
			if (i + 1 < size) {
				if (happy.get(i) < max && happy.get(i) > min) {
					int happyinessNext = getHappiness(currentHappiness, max, min, happy.get(i + 1));
					if (currentHappiness < happyinessNext) {
						currentHappiness = happyinessNext;
						max = Math.max(max, happy.get(i + 1));
						min = Math.min(min, happy.get(i + 1));
					}
					i = i + 2;
				} else {
					int happyinessI = getHappiness(currentHappiness, max, min, happy.get(i));
					int happyinessNext = getHappiness(currentHappiness, max, min, happy.get(i + 1));
					if (currentHappiness < happyinessI && happyinessNext < happyinessI) {
						currentHappiness = happyinessI;
						max = Math.max(max, happy.get(i));
						min = Math.min(min, happy.get(i));
					} else {
						if (currentHappiness < happyinessNext) {
							currentHappiness = happyinessNext;
							max = Math.max(max, happy.get(i + 1));
							min = Math.min(min, happy.get(i + 1));
						}
						i++;
					}
					i++;
				}
			} else {
				int happyinessI = getHappiness(currentHappiness, max, min, happy.get(i));
				if (currentHappiness < happyinessI) {
					currentHappiness = happyinessI;
					max = Math.max(max, happy.get(i));
					min = Math.min(min, happy.get(i));
				}
				i++;
			}
			//System.out.println(happy.get(i));
			count++;
			if (currentHappiness >= threshold) {
				return count;
			}
		}

		return happy.size();

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		// int threshold = Integer.parseInt(bufferedReader.readLine().trim());

		// int happyCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> happy = Lists.newArrayList(1, 2, 3,4,5);

		// for (int i = 0; i < happyCount; i++) {
		// int happyItem = Integer.parseInt(bufferedReader.readLine().trim());
		// happy.add(happyItem);
		// }

		int result = Result.minNum(4, happy);

		System.out.println(result);

		bufferedReader.close();

	}
}
