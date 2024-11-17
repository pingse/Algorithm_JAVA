import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int count = 1;
    static int[] visitedCount;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        visitedCount = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list.get(U).add(V);
            list.get(V).add(U);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        dfs(S);

        for (int i = 1; i < visitedCount.length; i++) {
            bw.write(Integer.toString(visitedCount[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        visitedCount[start] = count;

        for (int i = 0; i < list.get(start).size(); i++) {
            if (visitedCount[list.get(start).get(i)] == 0) {
                count++;
                dfs(list.get(start).get(i));
            }
        }
    }
}
