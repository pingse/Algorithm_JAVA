import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int F = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int answer = (F*2) + R+1;

            List<Integer>[] floors = new ArrayList[F+1];

            for (int j = 1; j<=F; j++) {
                floors[j] = new ArrayList<>();
            }

            for (int j = 0; j< N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                floors[a].add(b);
            }

            for (int j = 1; j<=F; j++) {
                floors[j].add(0);
                floors[j].add(R + 1);
                Collections.sort(floors[j]);

                int temp = Integer.MAX_VALUE;

                for (int k = 1; k<floors[j].size(); k++) {
                    int left = floors[j].get(k-1);
                    int right = floors[j].get(k);

                    temp = Math.min(temp, 2*(left + (R + 1 - right)));
                }

                answer += temp;
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
