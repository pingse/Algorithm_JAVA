import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int A;
    static int B;
    static boolean[] visited;
    static String[] command;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            command = new String[10000];
            Arrays.fill(command, "");

            bfs();
            bw.write(command[B] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        visited[A] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int D = (cur * 2) % 10000;
            int S = cur == 0 ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + (cur / 1000);
            int R = (cur % 10) * 1000 + (cur / 10);

            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                command[D] = command[cur] + "D";
            }

            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                command[S] = command[cur] + "S";
            }

            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                command[L] = command[cur] + "L";
            }

            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                command[R] = command[cur] + "R";
            }
        }
    }
}
