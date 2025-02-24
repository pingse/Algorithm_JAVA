import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;
        int[][] arr = new int[n][2];
        int answer = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            arr[i][0] = S;
            arr[i][1] = T;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                queue.add(arr[i][1]);
            } else {
                int cur = queue.peek();

                if (cur <= arr[i][0]) {
                    queue.poll();
                    queue.add(arr[i][1]);
                } else {
                    answer++;
                    queue.add(arr[i][1]);
                }
            }
        }
        System.out.print(answer);
    }
}
