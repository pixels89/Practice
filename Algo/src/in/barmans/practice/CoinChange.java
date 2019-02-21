package in.barmans.practice;

/**
 * Multiple ways to solve the coin change problem
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter. For example, for N = 4
 * and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So
 * output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five
 * solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output
 * should be 5.
 * 
 * @author mbarman
 *
 */
public class CoinChange {
	static int memo[][];
	public static int[] coins = { 1, 2, 4, 6, 8, 9, 3 };
	public static int amount = 100;

	static int comboOptimalSubstructure(int[] s, int m, int n) {
		if (n == 0)
			return 1;

		if (m <= 0 || n < 0)
			return 0;

		return comboOptimalSubstructure(s, m - 1, n) + comboOptimalSubstructure(s, m, n - s[m - 1]);
	}

	static int comboDP(int s[], int m, int n) {
		if (n == 0)
			return 1;

		if (m <= 0 || n < 0)
			return 0;

		if (memo[n][m] != -1) {
			return memo[n][m];
		}

		int count = comboDP(s, m - 1, n) + comboDP(s, m, n - s[m - 1]);

		memo[n][m] = count;
		return memo[n][m];
	}

	static int comboRecursive(int amount, int currentCoin, int[][] memo) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0) {
			return 0;
		}

		if (memo[amount][currentCoin] != -1) {
			return memo[amount][currentCoin];
		}

		int ways = 0;
		for (int coin = currentCoin; coin < coins.length; coin++) {
			ways += comboRecursive(amount - coins[coin], coin, memo);
		}
		memo[amount][currentCoin] = ways;
		return ways;
	}

	static int comboIteratively(int[] coins, int targetAmount) {
		int[] amounts = new int[amount + 1];

		for (int i = 0; i < amounts.length; i++) {
			amounts[i] = 0;
		}

		amounts[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i < amounts.length; i++) {
				if (i - coin >= 0) {
					amounts[i] += amounts[i - coin];
				}
			}
		}
		return amounts[amount];

	}

	public static void main(String[] args) {
		initMemo();
		System.out.println(comboDP(coins, coins.length, amount));
		System.out.println(comboOptimalSubstructure(coins, coins.length, amount));
		System.out.println(comboIteratively(coins, amount));
		initMemo();
		System.out.println(comboRecursive(amount, 0, memo));
	}

	private static void initMemo() {
		memo = new int[amount + 1][coins.length + 1];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				memo[i][j] = -1;
			}
		}
	}

}
