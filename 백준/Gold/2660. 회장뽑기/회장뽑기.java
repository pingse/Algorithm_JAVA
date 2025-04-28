import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                arr[i][j] = 987654321;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (u == -1 && v == -1) break;
            arr[u][v] = arr[v][u] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int score = 987654321;
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int s = 0;
            for (int j = 1; j <= n; j++) {
                s = Math.max(s, arr[i][j]);
            }
            scores[i] = s;
            score = Math.min(score, s);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(score + " ");
        StringBuilder sb2 = new StringBuilder();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (scores[i] == score) {
                count++;
                sb2.append(i + " ");
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
        System.out.println(sb2.toString());
    }
}
