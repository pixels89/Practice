package in.barmans.practice;

public class Quicksort {
	public static void main(String[] args) {

		int[] a = { 4, 2, 7, 5, 1, 3, 9, 8, 6 };

		quickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {

			System.out.println(a[i]);
		}
	}

	public static void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);

			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	private static int partition(int arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;

				int swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}

		int swapTemp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = swapTemp;

		return i + 1;
	}
}
