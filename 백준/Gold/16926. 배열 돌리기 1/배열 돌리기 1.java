import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int N, M, R;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate();
    }

    static void rotate() {
        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer<layers; layer++) {
            int t = layer;
            int l = layer;
            int b = N - layer - 1;
            int r = M - layer - 1;

            List<Integer> list = new ArrayList<>();

            for (int i = l; i <= r; i++) list.add(arr[t][i]);
            for (int i = t+1; i <= b-1; i++) list.add(arr[i][r]);
            for (int i = r; i >= l; i--) list.add(arr[b][i]);
            for (int i = b - 1; i >= t + 1; i--) list.add(arr[i][l]);

            int len = list.size();
            int rotate = R % len;

            int idx = 0;

            for (int i = l; i <= r; i++) arr[t][i] = list.get((idx++ + rotate) % len);
            for (int i = t+1; i <= b-1; i++) arr[i][r] = list.get((idx++ + rotate) % len);
            for (int i = r; i >= l; i--) arr[b][i] = list.get((idx++ + rotate) % len);
            for (int i = b - 1; i >= t + 1; i--) arr[i][l] = list.get((idx++ + rotate) % len);
        }

        StringBuilder sb = new StringBuilder();

        for (int[] row : arr) {
            for (int v : row) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
