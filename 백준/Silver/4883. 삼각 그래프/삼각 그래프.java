import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int k = 1;
        StringTokenizer st;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] graph = new int[n + 1][4];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i <= n; i++) {
                if (i == 2) {
                    graph[i][1] += graph[i - 1][2];
                    graph[i][2] += Math.min(graph[i][1], Math.min(graph[i - 1][2], graph[i - 1][2] + graph[i - 1][3]));
                    graph[i][3] += Math.min(graph[i][2], Math.min(graph[i - 1][2], graph[i - 1][2] + graph[i - 1][3]));
                } else {
                    graph[i][1] += Math.min(graph[i - 1][1], graph[i - 1][2]);
                    graph[i][2] += Math.min(graph[i - 1][1], Math.min(graph[i - 1][2], Math.min(graph[i][1], graph[i - 1][3])));
                    graph[i][3] += Math.min(graph[i - 1][2], Math.min(graph[i - 1][3], graph[i][2]));
                }
            }

            bw.write(Integer.toString(k) + ". " + Integer.toString(graph[n][2]) + "\n");

            k++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}