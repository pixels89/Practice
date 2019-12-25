package in.barmans.dp;

class LIS {

	static int lis(int arr[], int index, int prev) {
		if (index >= arr.length) 
			return 0;
		
		
		if (prev < arr[index]) {
			return Math.max(1 + lis(arr, index+1, arr[index]), lis(arr, index+1, prev));
		}else {
			return lis(arr, index+1, prev);
		}

	}

	static int lis(int arr[]) {

		return lis(arr, 0, Integer.MIN_VALUE);

	}

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println("Length of lis is " + lis(arr) + "\n");
	}
}
