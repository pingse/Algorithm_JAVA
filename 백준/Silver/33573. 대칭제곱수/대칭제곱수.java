import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(br.readLine());

            long b = 0;
            long temp = a;
            while (temp > 0) {
                b = b * 10 + temp % 10;
                temp /= 10;
            }

            long x = (long)Math.sqrt(a);
            long y = (long)Math.sqrt(b);

            if (x * x == a && y * y == b) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb.toString());
    }
}
