import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int temp = lcm / gcd;
        long a=0;
        long b=0;
        for (int i = 1; i*i<=temp; i++) {
            if (temp % i == 0) {
                int x = i;
                int y = temp / i;
                if (gcd(x, y) == 1) {
                    a = x * gcd;
                    b = y * gcd;
                }
            }
        }
        System.out.println(a + " " + b);
    }

    static int gcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
