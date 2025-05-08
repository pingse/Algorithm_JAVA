import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] coins = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] ans = new int[N + 1][T + 1];
        ans[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            int nCoin = coins[i][0];
            for (int j = 0; j <= coins[i][1]; j++) {
                for (int k = 0; k <= T; k++) {
                    int nValue = k + nCoin*j;
                    if (nValue > T) break;
                    ans[i][nValue] += ans[i - 1][k];
                }
            }
        }
        System.out.print(ans[N][T]);
    }
}
