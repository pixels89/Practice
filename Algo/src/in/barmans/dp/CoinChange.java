package in.barmans.dp;

class CoinChange {

	public static void main(String[] args) {

		int[] denominations = new int[] { 1,  5, 10 };
		System.out.println("Combinations (DP): " + gameScoring(denominations, 356));
	}

	static int gameScoring(int[] scores, int score) {

		return coinChange(scores, score, 0);
	}

	static int coinChange(int[] denom, int amount, int index) {

		if (amount == 0)
			return 1;

		if (denom == null || denom.length == 0 || index < 0 || index >= denom.length || amount < 0)
			return 0;

//		int count = 0;
//		for (int i = 0; i < denom.length; i++) {
//			count += gameScoring(denom, amount - denom[i], index + i);
//		}

		return coinChange(denom, amount - denom[index], index) + coinChange(denom, amount, index + 1);

	}
}