import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] member = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            member[i] = Integer.parseInt(br.readLine());
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(member[0]);
        visited[member[0]] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            if (cur == m) {
                System.out.print(count);
                System.exit(0);
            }
            if (!visited[member[cur]]) {
                queue.add(member[cur]);
                visited[cur] = true;
            }
        }

        System.out.print("-1");
    }
}
