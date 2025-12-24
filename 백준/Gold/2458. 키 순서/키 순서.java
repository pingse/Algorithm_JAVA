import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;

        boolean[][] floyd = new boolean[n+1][n+1];

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            floyd[start][end] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (!floyd[i][k]) continue;
                for (int j = 1; j <= n; j++) {
                    if (floyd[k][j]) {
                        floyd[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i<=n; i++) {
            int count = 0;
            for (int j = 1; j<=n; j++) {
                if (floyd[i][j] || floyd[j][i]) count++;
            }
            if (count == n-1) answer++;
        }

        System.out.println(answer);
    }
}
