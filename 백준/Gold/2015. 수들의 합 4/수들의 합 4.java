import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long sum = 0;
        long answer = 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            sum += Integer.parseInt(st.nextToken());

            if (map.containsKey(sum - K)) {
                answer += map.get(sum - K);
            }

            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }
        System.out.println(answer);
    }
}
