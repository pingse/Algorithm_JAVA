import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static Integer[] dp;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
        }
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write(Integer.toString(max) + "\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == max) {
                stack.push(arr[i]);
                max--;
            }
        }

        while (!stack.isEmpty()) {
            bw.write(Integer.toString(stack.pop()) + " ");
        }
        bw.flush();
        bw.close();
        br.close();


    }

    static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n -1; i >= 0; i--) {
                if (arr[n] > arr[i]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
