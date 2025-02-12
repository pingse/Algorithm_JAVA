import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] seat = new int[n + 1];
        int[] vip = new int[m];
        int ans = 1;

        for (int i = 0; i < m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        seat[0] = 1;
        seat[1] = 1;

        for (int i = 2; i <= n; i++) {
            seat[i] = seat[i - 1] + seat[i - 2];
        }

        int temp = 0;
        for (int idx : vip) {
            ans *= seat[idx - temp - 1];
            temp = idx;
        }
        ans *= seat[n - temp];

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();

    }
}
