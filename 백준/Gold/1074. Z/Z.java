import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int r;
    static int c;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        z(r, c, (int) Math.pow(2, n));
        System.out.println(count);
    }

    static void z(int y, int x, int size) {
        if (size == 1) {
            return;
        }
        if (y < size / 2 && x < size / 2) {
            z(y, x, size / 2);
        } else if (y < size / 2 && x >= size / 2) {
            count += size * size / 4;
            z(y, x - size / 2, size / 2);
        } else if (y >= size / 2 && x < size / 2) {
            count += size * size / 2;
            z(y - size / 2, x, size / 2);
        } else {
            count += size * size / 4 * 3;
            z(y - size / 2, x - size / 2, size / 2);
        }
    }
}
