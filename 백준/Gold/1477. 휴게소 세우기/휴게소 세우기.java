import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 0;
        arr[n+1] = l;

        Arrays.sort(arr);
        int start = 1;
        int end = l-1;
        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i = 1; i < arr.length; i++) {
                sum+= (arr[i] - arr[i-1] -1) / mid;
            }

            if (sum > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(start);
    }
}
