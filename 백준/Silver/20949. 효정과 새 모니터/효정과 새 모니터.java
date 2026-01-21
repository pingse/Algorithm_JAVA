import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Map<Integer, Double> monitors = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i<=n; i++) {
            answer.add(i);
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            monitors.put(i, Math.sqrt(w*w + h*h) / 77);
        }

        Collections.sort(answer, (o1, o2) -> {
            if (monitors.get(o1) == monitors.get(o2)) {
                return o1 - o2;
            } else {
                return monitors.get(o2).compareTo(monitors.get(o1));
            }
        });

        for (int i = 0; i<n; i++) {
            bw.write(answer.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
