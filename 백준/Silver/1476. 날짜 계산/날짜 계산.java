import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ec = 1;
        int sc = 1;
        int mc = 1;
        int count = 1;

        while (true) {
            if (ec == e && sc == s && mc == m) {
                break;
            }
            ec++;
            sc++;
            mc++;
            count++;

            if (ec == 16) {
                ec = 1;
            }
            if (sc == 29) {
                sc = 1;
            }
            if (mc == 20) {
                mc = 1;
            }
        }
        System.out.print(count);
    }
}
