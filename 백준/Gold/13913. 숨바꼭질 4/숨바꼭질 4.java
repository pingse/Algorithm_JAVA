import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp = new int[100001];
    static int myPoint;
    static int otherPoint;
    static int[] dist = new int[100001];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        myPoint = Integer.parseInt(st.nextToken());
        otherPoint = Integer.parseInt(st.nextToken());
        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(otherPoint);
        int index = otherPoint;

        while (index != myPoint) {
            stack.push(dist[index]);
            index = dist[index];
        }
        bw.write(Integer.toString(dp[otherPoint]-1) + "\n");

        while (!stack.isEmpty()) {
            bw.write(Integer.toString(stack.pop()) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(myPoint);
        dp[myPoint] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == otherPoint) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;

                if (i == 0) next = cur + 1;
                else if (i == 1) next = cur - 1;
                else next = cur * 2;

                if (next < 0 || next > 100000) continue;

                if (dp[next] == 0) {
                    queue.add(next);
                    dp[next] = dp[cur] +1;
                    dist[next] = cur;
                }
            }
        }
    }
}
