import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while (right <= N && left <= right) {
            if (sum < S) {
                sum += arr[right++];
            } else if (sum >= S) {
                ans = Math.min(ans, right-left);
                sum -= arr[left++];
            }
        }

        bw.write(ans == Integer.MAX_VALUE ? "0" : Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
