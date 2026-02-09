import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        long oddLen;
        long evenLen = Long.MAX_VALUE;

        if (N <= 9) {
            oddLen = 1;
        } else {
            long k = (N - 9 + 17) / 18; // ceil
            oddLen = 2 * k + 1;
        }

        if (N % 2 == 0) {
            long k = (N + 17) / 18; // ceil
            evenLen = 2 * k;
        }

        System.out.println(Math.min(oddLen, evenLen));
    }
}
