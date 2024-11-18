import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] seq;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        seq = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i), (o1, o2) -> {
                return o2.compareTo(o1);
            });
        }
        bfs(K);
        for (int i = 1; i < seq.length; i++) {
            bw.write(Integer.toString(seq[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        seq[start] = count++;

        while (!queue.isEmpty()) {
            for (Integer n : list.get(queue.poll())) {
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    seq[n] = count++;
                }
            }
        }

    }
}
