import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = 0;
        int Y = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            now = Integer.parseInt(st.nextToken());

            Y += ((now / 30)+1) * 10;
            M += ((now / 60)+1) * 15;
        }

        if (M == Y) {
            bw.write("Y M " + Integer.toString(M));
        } else {
            bw.write(M > Y ? "Y " + Integer.toString(Y) : "M " + Integer.toString(M));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
