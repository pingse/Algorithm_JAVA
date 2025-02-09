import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s= 0;

        int[][] sum = new int[n+1][n + 1];
        Arrays.fill(sum[0], 0);

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sum[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                sum[i][j] = Integer.parseInt(st.nextToken()) + sum[i][j - 1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            s = sum[x2][y2] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1] - sum[x2][y1 - 1];
            bw.write(Integer.toString(s) + "\n");
            s = 0;
        }
        bw.flush();
        bw.close();
    }
}
