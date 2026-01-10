import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] sum = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i<=n; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i<t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            bw.write(sum[second] - sum[first-1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
