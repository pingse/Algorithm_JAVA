import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        br.close();

        long gcd = gcd(a, b);
        long lcm = a * b / gcd;

        bw.write(Long.toString(lcm));
        bw.flush();
        bw.close();

    }

    static long gcd(long a, long b) {
        long r = 0;

        while (true) {
            if (a % b == 0) {
                break;
            } else {
                r = a % b;
                a = b;
                b = r;
            }
        }

        return b;
    }
}
