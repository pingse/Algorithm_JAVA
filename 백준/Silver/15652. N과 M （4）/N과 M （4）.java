import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static int[] value;
    static int n;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        value = new int[m];
        backTracking(0,0);
        bw.flush();
        bw.close();
    }

    static void backTracking(int depth, int start) throws IOException {
        if (value.length == depth) {
            for (int val : value) {
                bw.write(Integer.toString(val) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            value[depth] = i+1;
            backTracking(depth+1, i);
        }
        return;
    }
}
