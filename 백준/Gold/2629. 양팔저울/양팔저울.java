import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int n;
    static int m;
    static boolean[][] weight = new boolean[31][15001];
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        findBall(0, 0);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value > 15000) {
                bw.write("N ");
            } else {
                if (weight[n][value]) {
                    bw.write("Y ");
                } else {
                    bw.write("N ");
                }
            }
        }
        bw.flush();
        bw.close();

    }

    static void findBall(int c, int w) {
        if (weight[c][w]) return;
        weight[c][w] = true;

        if (c == n) {
            return;
        }

        findBall(c + 1, w + arr[c + 1]);
        findBall(c + 1, w);
        findBall(c+1, Math.abs(w - arr[c+1]));
    }
}
