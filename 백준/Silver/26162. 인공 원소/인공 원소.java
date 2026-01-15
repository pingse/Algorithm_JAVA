import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> prime = new ArrayList<>();
    static boolean[] canSumPrime = new boolean[119];
    public static void main(String[] args) throws IOException {
        for (int i = 2; i<=118; i++) {
            if (isPrime(i)) prime.add(i);
        }

        for (int i = 0; i<prime.size(); i++) {
            for (int j = 0; j<prime.size(); j++) {
                int now = prime.get(i) + prime.get(j);

                if (now < 119) canSumPrime[now] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++) {
            int test = Integer.parseInt(br.readLine());

            bw.write(canSumPrime[test] ? "Yes\n" : "No\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isPrime(int x) {
        if (x == 2) return true;

        for (int i = 2; i<=Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}
