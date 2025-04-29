import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                map[i][j] = 987654321;
            }
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[u][v] = w;
        }

        int people = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < people; j++) {
                int now = list.get(j);
                dist[i] = Math.max(dist[i], map[i][now] + map[now][i]);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int maxLength = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= n; i++) {
            if (maxLength > dist[i]) {
                list.clear();
                list.add(i);
                maxLength = dist[i];
            } else if (maxLength == dist[i]) {
                list.add(i);
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
