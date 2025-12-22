import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int r = gcd(a, b);

            bw.write((a*b/r) + " " + r + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        int r = 0;

        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
