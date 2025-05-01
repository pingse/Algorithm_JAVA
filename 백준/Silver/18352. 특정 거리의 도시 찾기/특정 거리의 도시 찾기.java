import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K, X;
    static int[] answer;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            answer[i] = Integer.MAX_VALUE;
        }
        answer[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
        }

        bfs();
        int size = ans.size();

        if (size == 0) bw.write("-1");
        else {
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                bw.write(ans.get(i) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        visited[X] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : list.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    answer[next] = answer[cur] + 1;
                    queue.add(next);
                    if (answer[next] == K) {
                        ans.add(next);
                    }
                }
            }
        }
    }
}
