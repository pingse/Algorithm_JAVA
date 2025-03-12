import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int length = y - x;
            int max = (int) Math.sqrt(length);

            if (max == Math.sqrt(length)) {
                bw.write(max * 2 - 1 + "\n");
            } else if (length <= max * max + max) {
                bw.write(max * 2 + "\n");
            } else {
                bw.write(max * 2 + 1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
