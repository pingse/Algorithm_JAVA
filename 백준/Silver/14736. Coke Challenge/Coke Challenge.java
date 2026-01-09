import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            int sleep = Integer.parseInt(st.nextToken());

            int totalT = K / A;
            int restC = (K % (time * A)) == 0 ? (K / (time * A)) - 1 : (K / (time * A));

            int now = totalT + restC*sleep;
            answer = Math.min(now, answer);
        }

        System.out.println(answer);
    }
}
