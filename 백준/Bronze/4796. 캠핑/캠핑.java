import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int i = 1;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (l == p && p == v && l == 0) {
                break;
            }
            int result = (v/p)*l + Math.min(v % p, l);

            bw.write("Case " + i + ": " + result + "\n");
            i++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
