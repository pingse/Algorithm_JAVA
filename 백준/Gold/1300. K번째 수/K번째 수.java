import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long max = k;

        bw.write(Long.toString(findNum(1, max, k)));
        bw.flush();
        bw.close();
    }

    static long findNum(long start, long end, int value) {
        while (start < end) {
            long half = (start + end) / 2;
            if (value <= calNum(half)) {
                end = half;
            } else {
                start = half + 1;
            }
        }

        return end;
    }

    static int calNum(long half) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += Math.min(half / i, n);
        }

        return count;
    }
}
