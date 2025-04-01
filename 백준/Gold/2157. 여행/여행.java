import java.io.*;
import java.util.*;

public class Main {

    static class Travel {
        int destination;
        int score;

        Travel(int destination, int score) {
            this.destination = destination;
            this.score = score;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;

        List<Travel>[] lists = new ArrayList[n + 1];

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[1][1] = 0;

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (from < to) {
                lists[from].add(new Travel(to, value));
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                for (Travel travel : lists[j]) {
                    int next = travel.destination;
                    int cost = travel.score;

                    dp[i + 1][next] = Math.max(dp[i + 1][next], dp[i][j] + cost);
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            max = Math.max(dp[i][n], max);
        }
        System.out.print(max);

    }
}
