import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        int[] arr = new int[n];
        arr2 = new int[n * (n+1) / 2];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                arr2[count++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(arr2);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (binarySearch(arr[i] - arr[j])) {
                    System.out.print(arr[i]);
                    System.exit(0);
                }
            }
        }
    }

    static boolean binarySearch(int n) {
        int start = 0;
        int end = arr2.length-1;

        while (start <= end) {
            int mid = (start + end) /2;

            if (arr2[mid] > n) {
                end = mid - 1;
            } else if (arr2[mid] < n) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
