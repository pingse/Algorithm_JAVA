import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[][] route = new int[n + 1][n + 1];
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                route[i][j] = 987654321;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            route[u][v] = route[v][u] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (m >= route[i][k] + route[k][j]) {
                        route[i][j] = Math.min(route[i][k] + route[k][j], route[i][j]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (route[i][j] <= m) {
                    items[i] += arr[j];
                }
            }
            max = Math.max(items[i], max);
        }
        System.out.print(max);
    }
}
