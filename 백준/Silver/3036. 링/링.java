import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n - 1; i++) {
            int B = Integer.parseInt(st.nextToken());
            int gcd = euclidean(A, B);
            bw.write(A / gcd + "/" + B / gcd + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int euclidean(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        int r = a % b;

        return euclidean(b, r);
    }
}
