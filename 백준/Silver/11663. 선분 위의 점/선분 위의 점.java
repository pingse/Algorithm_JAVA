import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[N];
        for (int i = 0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            int l1 = 0;
            int r1 = N-1;
            int ans1 = 0;
            while (l1 <= r1) {
                int mid1 = (l1 + r1) / 2;

                if (arr[mid1] < start) {
                    l1 = mid1+1;
                } else {
                    r1 = mid1 - 1;
                }
            }
            ans1 = l1;

            int l2 = 0;
            int r2 = N - 1;
            int ans2 = 0;
            while (l2 <= r2) {
                int mid2 = (l2 + r2) / 2;

                if (arr[mid2] > end) {
                    r2 = mid2 - 1;
                } else {
                    l2 = mid2 + 1;
                }
            }
            ans2 = r2+1;

            bw.write(ans2 - ans1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
