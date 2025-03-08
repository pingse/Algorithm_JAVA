import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] num = new boolean[n + 1];

        int idx = 1;
        boolean state = false;
        while (true) {
            state = false;
            int now = 0;
            for (int i = 2; i <= n; i++) {
                if (!num[i]) {
                    now = i;
                    break;
                }
            }

            for (int i = 2; i <= n; i++) {
                if (i % now == 0 && !num[i]) {
                    num[i] = true;
                    if (idx == k) {
                        System.out.print(i);
                        state = false;
                        break;
                    } else {
                        idx++;
                    }
                }
                if (!num[i]) {
                    state = true;
                }
            }

            if (!state) {
                break;
            }
        }
    }
}
