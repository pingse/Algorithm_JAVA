import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int mid = (N+1)/2;
        int answer = 0;

        boolean[][] visited = new boolean[N+1][N+1];

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            visited[u][v] = true;
        }

        for (int k = 1; k<=N; k++) {
            for (int i = 1; i<=N; i++) {
                for (int j = 1; j<=N; j++) {
                    if (visited[i][k] && visited[k][j]) {
                        visited[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i<=N; i++) {
            int h = 0;
            int s = 0;

            for (int j = 1; j<=N; j++) {
                if (visited[i][j]) {
                    s++;
                }
                if (visited[j][i]) {
                    h++;
                }
            }

            if (h >= mid || s >= mid) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
