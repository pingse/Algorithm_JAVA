import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dist = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0, idx = 0;
        dist[0] = Integer.MIN_VALUE;
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            if (arr[i] > dist[len]) {
                dp[i] = ++len;
                dist[len] = arr[i];
            } else {
                idx = binarySearch(0, len, arr[i]);
                dist[idx] = arr[i];
                dp[i] = idx;
            }
        }
        bw.write(Integer.toString(len) + "\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == len) {
                stack.push(arr[i]);
                len--;
            }
        }
        while (!stack.isEmpty()) {
            bw.write(Integer.toString(stack.pop()) + " ");
        }
        bw.flush();
        bw.close();
        br.close();



    }

    static int binarySearch(int left, int right, int value) {
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (dist[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}