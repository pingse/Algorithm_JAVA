import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());

        long a = A;
        long b = B;
        long c = C;
        long d = D;

        if (B * C > A * D) {
            a = C;
            b = D;
            c = A;
            d = B;
        }

        long min = Long.MAX_VALUE;

        for (long i = 0; i < a; i++) {
            long value = (long) Math.ceil((double) (N - i * c) / a);

            boolean isOver = false;
            if (value < 0) {
                value = 0;
                isOver = true;
            }

            min = Math.min(min, value * b + i*d);
            if (isOver) {
                break;
            }
        }
        System.out.print(min);
    }
}
