import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long sum = queue.poll() + queue.poll();
            queue.add(sum);
            queue.add(sum);
        }

        for (int i = 0; i < n; i++) {
            answer += queue.poll();
        }
        System.out.print(answer);
    }
}
