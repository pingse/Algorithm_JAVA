import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] visited;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list.get(U).add(V);
            list.get(V).add(U);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i), (o1, o2) -> {
                return o2.compareTo(o1);
            });
        }

        dfs(S);

        for (int i = 1; i < visited.length; i++) {
            bw.write(Integer.toString(visited[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int start) {
        visited[start] = count;

        for (int i = 0; i < list.get(start).size(); i++) {
            if (visited[list.get(start).get(i)] == 0) {
                count++;
                dfs(list.get(start).get(i));
            }
        }
    }
}
