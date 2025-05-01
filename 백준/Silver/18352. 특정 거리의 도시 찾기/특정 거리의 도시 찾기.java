import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K, X;
    static int[] answer;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
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
        Dijkstra();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (answer[i] == K) {
                ans.add(i);
            }
        }
        int size = ans.size();

        if (size == 0) bw.write("-1");
        else {
            for (int i = 0; i < ans.size(); i++) {
                bw.write(ans.get(i) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void Dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{X, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]] = true;

            for (int next : list.get(cur[0])) {
                if (!visited[next] && answer[next] > cur[1] + 1) {
                    answer[next] = cur[1] + 1;
                    pq.add(new int[]{next, answer[next]});
                }
            }
        }
    }
}
