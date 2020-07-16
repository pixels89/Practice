package in.barmans.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotatedArray {

    private static int findElement(int[] arr, int k) {
        if (arr == null || arr.length == 0) return -1;

        int st = 0;
        int end = arr.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[st] <= arr[mid]) {

                if (arr[st] <= k && k <= arr[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {

                if (arr[mid] <= arr[end]) {
                    if (arr[mid] <= k && k <= arr[end]) {
                        st = mid + 1;
                    } else {

                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int x = Integer.parseInt(br.readLine());
            int output = findElement(arr, x);
            System.out.println(output);
        }
    }
}
