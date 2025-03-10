import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        boolean[] prime = new boolean[(int) Math.sqrt(b) + 1];
        int count = 0;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i*2; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                long temp = i;

                while (temp <= (double) b / i) {
                    if (temp >= (double) a / i) {
                        count++;
                    }
                    temp *= i;
                }
            }
        }
        System.out.print(count);
    }
}
