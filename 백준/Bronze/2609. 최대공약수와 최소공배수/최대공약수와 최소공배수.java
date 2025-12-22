import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int r = gcd(a, b);

        System.out.println(r);
        System.out.println(a*b/r);

    }

    static int gcd(int a, int b) {
        int r;

        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
