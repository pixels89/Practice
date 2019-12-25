package in.barmans.practice;

public class CIrcularArray {
	public static void main(String[] args) {

		int[] a = { -2,-1,-1,-2,-2};
		boolean circular = checkCircular(a);
		System.out.println(circular);
	}

	private static boolean checkCircular(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {

				int start = i;
				int j;
				boolean pos = a[start] > 0;
				int length = 1;

				j = ((start + a[start]) + a.length) % a.length;
				while (j != start && a[j] != 0 && (a[j] > 0 == pos)) {

					length++;
					int temp = j;
					j = (j + a[j]) % a.length;
					a[temp] = 0;
				}
				if (j == start && length > 1) {
					return true;
				}
			}
		}
		return false;
	}
}
