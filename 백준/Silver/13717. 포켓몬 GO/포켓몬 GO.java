import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = 0;
        int answer = 0;
        String name = "";
        for (int i = 0; i < N; i++) {
            String poketmon = br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            while (m - k >= 0) {
                m -= k;
                count++;
                m += 2;
            }

            answer += count;
            if (max < count) {
                max = count;
                name = poketmon;
            }
        }

        System.out.println(answer);
        System.out.println(name);
    }
}
