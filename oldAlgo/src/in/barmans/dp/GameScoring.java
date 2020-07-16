package in.barmans.dp;

class GameScoring {

	public static void main(String[] args) {

		int[] denominations = new int[] { 1, 2, 4 };
		System.out.println("Combinations (DP): " + gameScoring(denominations, 5));
	}

	static int gameScoring(int[] scores, int score) {

		return gameScoring(scores, score, 0);
	}

	static int gameScoring(int[] points, int score, int index) {
		
		if (score == 0)
			return 1;

		if (points == null || points.length == 0 || index < 0 || index >= points.length
				|| score < 0)
			return 0;

		int count = 0;
		for (int i = 0; i < points.length; i++) {
			count += gameScoring(points, score - points[i], index + i);
		}
		System.out.println(score + " " + index + " " + count);
		return count;
	}
}