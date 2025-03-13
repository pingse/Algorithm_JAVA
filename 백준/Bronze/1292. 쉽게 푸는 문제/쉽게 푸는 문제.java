import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int total = 0;
        int idx = 0;
        int answer = 0;
        while (total < 1001) {
            idx++;
            for (int i = 0; i < idx; i++) {
                total++;
                if (total >= n) {
                    answer+=idx;
                }
                if (total == m) {
                    System.out.print(answer);
                    System.exit(0);
                }
            }
        }
    }
}
